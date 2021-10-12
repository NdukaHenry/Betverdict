package com.betverdict.berverdict.services;

import java.util.List;

import com.betverdict.berverdict.entities.FreeMarketCategory;

public interface FreeMarketCategoryService {
	void createCategory(FreeMarketCategory freeMarketCategory);

	List<FreeMarketCategory> getAllMarketCategory();

	void deleteMarketById(Long id);
}
