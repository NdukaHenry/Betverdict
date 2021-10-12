package com.betverdict.berverdict.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.entities.Products;
import com.betverdict.berverdict.repositories.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public void createProduct(Products products) {

		if (productsRepository.exists(Example.of(products))) {
			throw new RuntimeException("Product " + products.getProductName() + " Already Exist");
		} else {
			this.productsRepository.save(products);
		}
	}

	@Override
	public List<Products> getAllProductsCategory() {

		return productsRepository.findAll();
	}

	@Override
	public void deleteProductsById(Long id) {
		productsRepository.deleteById(id);
	}
}


