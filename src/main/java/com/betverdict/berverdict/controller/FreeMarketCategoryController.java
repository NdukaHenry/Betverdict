package com.betverdict.berverdict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.betverdict.berverdict.entities.FreeMarketCategory;
import com.betverdict.berverdict.services.FreeMarketCategoryService;

@Controller
public class FreeMarketCategoryController {


	@Autowired
	private FreeMarketCategoryService freeMarketCategoryService;

	@RequestMapping(value = "/freemarket", method = RequestMethod.GET)
	public String displayFreeMarketPage(Model model) {
		model.addAttribute("listFreeMarketCategory", freeMarketCategoryService.getAllMarketCategory());
		return "admin/freemarket.html";

	}

	@RequestMapping(value = "/createfreemarketcat", method = RequestMethod.GET)
	public String createFreeMarketCategory(Model model) {
		final FreeMarketCategory freeMarketCategory = new FreeMarketCategory();
		model.addAttribute("freeMarketCategory", freeMarketCategory);
		return "admin/createfreemarketcat.html";

	}

	@RequestMapping(value = "/saveCategoryForFree", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("freeMarketCategory") FreeMarketCategory freeMarketCategory) {
		freeMarketCategoryService.createCategory(freeMarketCategory);
		return "redirect:/createfreemarketcat";
	}

	@RequestMapping(value = "/deleteFromFree", method = RequestMethod.GET)
	public String deleteMarket(@RequestParam(name = "id") Long id) {
		freeMarketCategoryService.deleteMarketById(id);
		return "redirect:/freemarket";
	}


}
