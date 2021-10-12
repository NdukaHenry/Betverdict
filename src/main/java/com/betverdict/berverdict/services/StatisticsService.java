package com.betverdict.berverdict.services;

import java.util.List;

import com.betverdict.berverdict.entities.Statistics;

public interface StatisticsService {
	void createStat(Statistics statistics);

	List<Statistics> getAllStatistics();

	void deleteStatisticsById(Long id);
}
