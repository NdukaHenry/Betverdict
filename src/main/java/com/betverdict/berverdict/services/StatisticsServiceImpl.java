package com.betverdict.berverdict.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.entities.Statistics;
import com.betverdict.berverdict.repositories.StatisticsRepository;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsRepository statisticsRepository;

	@Override
	public void createStat(Statistics statistics) {

		if (statisticsRepository.exists(Example.of(statistics))) {
			throw new RuntimeException("Category " + statistics.getName() + " Already Exist");
		} else {
			this.statisticsRepository.save(statistics);
		}
	}

	@Override
	public List<Statistics> getAllStatistics() {
		return this.statisticsRepository.findAll();
	}

	@Override
	public void deleteStatisticsById(Long id) {
		this.statisticsRepository.deleteById(id);

	}

}
