package com.betverdict.berverdict.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.entities.FreeMarketCategory;
import com.betverdict.berverdict.repositories.FreeMarketCategoryRepository;

@Service
public class FreeMarketCategoryServiceImpl implements FreeMarketCategoryService {

	@Autowired
	private FreeMarketCategoryRepository freeMarketCategoryRepository;

	@Override
	public void createCategory(FreeMarketCategory freeMarketCategory) {

		if (freeMarketCategoryRepository.exists(Example.of(freeMarketCategory))) {
			throw new RuntimeException(
					"Category "  +freeMarketCategory.getMarketName()+ " Already Exist");
		} else {
			this.freeMarketCategoryRepository.save(freeMarketCategory);
		}
}

	@Override
	public List<FreeMarketCategory> getAllMarketCategory() {

		return freeMarketCategoryRepository.findAll();
	}

	@Override
	public void deleteMarketById(Long id) {
		freeMarketCategoryRepository.deleteById(id);


	}

}
