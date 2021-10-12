package com.betverdict.berverdict.services;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.betverdict.berverdict.entities.GameVerdict;
import com.betverdict.berverdict.entities.VerdictAnalysis;

public interface GameVerdictService {

	void createGameVerdict(Date date, String team1Name, String team2Name, MultipartFile file1, MultipartFile file2,
			List<VerdictAnalysis> analysis, String verdict);

	List<GameVerdict> getAllGameVerdicts();


}
