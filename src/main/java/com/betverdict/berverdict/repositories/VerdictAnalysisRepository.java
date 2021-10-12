package com.betverdict.berverdict.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betverdict.berverdict.entities.VerdictAnalysis;

@Repository
public interface VerdictAnalysisRepository extends JpaRepository<VerdictAnalysis, Long> {

}
