package com.betverdict.berverdict.services;

import java.util.List;

import com.betverdict.berverdict.entities.SpecialMarketCategory;

public interface SpecialMarketCategoryService {

	void createCategory(SpecialMarketCategory specialMarketCategory);

	List<SpecialMarketCategory> getAllMarketCategory();

	void deleteMarketById(Long id);
}
