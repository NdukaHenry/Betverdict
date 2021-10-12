package com.betverdict.berverdict.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.repositories.VerdictAnalysisRepository;

@Service
public class VerdictAnalysisServiceImpl implements VerdictAnalysisService {

	@Autowired
	VerdictAnalysisRepository verdictAnalysisRepository;



	@Override
	public void createAnalysis(Long gameVerdictId, String statName, String statCategory, Integer team1Point,
			Integer team2Point2) {

	}



}
