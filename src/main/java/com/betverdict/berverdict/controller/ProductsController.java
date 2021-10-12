package com.betverdict.berverdict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.betverdict.berverdict.entities.Products;
import com.betverdict.berverdict.services.ProductsService;

@Controller
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String displayProducts(Model model) {
		model.addAttribute("listProducts", productsService.getAllProductsCategory());
		return "admin/products.html";

	}

	@RequestMapping(value = "/createproducts", method = RequestMethod.GET)
	public String createProducts(Model model) {
		final Products products = new Products();
		model.addAttribute("products", products);
		return "admin/createproducts.html";

	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("products") Products products) {
		productsService.createProduct(products);
		return "redirect:/createproducts";
	}

	@RequestMapping(value = "/deleteProducts", method = RequestMethod.GET)
	public String deleteProducts(@RequestParam(name = "id") Long id) {
		productsService.deleteProductsById(id);
		return "redirect:/products";
	}

}
