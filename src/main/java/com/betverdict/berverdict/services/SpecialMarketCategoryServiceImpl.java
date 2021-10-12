package com.betverdict.berverdict.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.entities.SpecialMarketCategory;
import com.betverdict.berverdict.repositories.SpecialMarketCategoryRepository;

@Service
public class SpecialMarketCategoryServiceImpl implements SpecialMarketCategoryService {

	@Autowired
	private SpecialMarketCategoryRepository specialMarketCategoryRepository;

	@Override
	public void createCategory(SpecialMarketCategory specialMarketCategory) {

		if (specialMarketCategoryRepository.exists(Example.of(specialMarketCategory))) {
			throw new RuntimeException("Category " + specialMarketCategory.getMarketName() + " Already Exist");
		} else {
			this.specialMarketCategoryRepository.save(specialMarketCategory);
		}
	}

	@Override
	public List<SpecialMarketCategory> getAllMarketCategory() {

		return specialMarketCategoryRepository.findAll();
	}

	@Override
	public void deleteMarketById(Long id) {
		specialMarketCategoryRepository.deleteById(id);

	}
}
