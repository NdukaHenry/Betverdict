package com.betverdict.berverdict.services;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.betverdict.berverdict.entities.GameVerdict;
import com.betverdict.berverdict.entities.VerdictAnalysis;
import com.betverdict.berverdict.repositories.GameVerdictRepository;

@Service
public class GameVerdictServiceImpl implements GameVerdictService {

	@Autowired
	private GameVerdictRepository gameVerdictRepository;


	@Override
	public void createGameVerdict(Date date, String team1Name, String team2Name, MultipartFile file1,
			MultipartFile file2, List<VerdictAnalysis> analysis,
			String verdict) {
		final GameVerdict gameVerdict = new GameVerdict();

		final String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
		final String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());

		if (fileName1.contains("..") || fileName2.contains("..")) {
			System.out.println("Not a valid file");
		}
         try {
				gameVerdict.setImage1(Base64.getEncoder().encodeToString(file1.getBytes()));
				gameVerdict.setImage2(Base64.getEncoder().encodeToString(file2.getBytes()));
			} catch (final IOException e) {
				e.printStackTrace();
			}

			gameVerdict.setDate(date);
		gameVerdict.setTeam1Name(team1Name);
		gameVerdict.setTeam2Name(team2Name);
		gameVerdict.setVerdict(verdict);

		gameVerdictRepository.save(gameVerdict);
	}

	@Override
	public List<GameVerdict> getAllGameVerdicts() {

		return gameVerdictRepository.findAll();
	}




}
