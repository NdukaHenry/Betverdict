package com.betverdict.berverdict.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betverdict.berverdict.entities.Statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

}
