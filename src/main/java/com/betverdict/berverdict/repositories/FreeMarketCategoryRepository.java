package com.betverdict.berverdict.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betverdict.berverdict.entities.FreeMarketCategory;

@Repository
public interface FreeMarketCategoryRepository extends JpaRepository<FreeMarketCategory, Long> {


	// @Query("select fmc from FreeMarketCategory fmc where fmc.marketName =
	// :#{freeMarketCategory.marketName}")
	// Optional<FreeMarketCategory> findMarketByName(@Param("freeMarketCategory")
	// FreeMarketCategory freeMarketCategory);
}
