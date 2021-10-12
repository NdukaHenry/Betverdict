package com.betverdict.berverdict.services;

public interface VerdictAnalysisService {
	void createAnalysis(Long gameVerdictId, String statName, String statCategory, Integer team1Point,
			Integer team2Point2);


}
