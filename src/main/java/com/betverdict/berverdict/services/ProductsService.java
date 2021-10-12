package com.betverdict.berverdict.services;

import java.util.List;

import com.betverdict.berverdict.entities.Products;

public interface ProductsService {
	void createProduct(Products products);

	List<Products> getAllProductsCategory();

	void deleteProductsById(Long id);
}
