package com.betverdict.berverdict.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betverdict.berverdict.entities.SpecialMarketCategory;

@Repository
public interface SpecialMarketCategoryRepository extends JpaRepository<SpecialMarketCategory, Long> {

}
