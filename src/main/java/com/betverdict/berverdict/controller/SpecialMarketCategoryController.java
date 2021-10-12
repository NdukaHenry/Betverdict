package com.betverdict.berverdict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.betverdict.berverdict.entities.SpecialMarketCategory;
import com.betverdict.berverdict.services.SpecialMarketCategoryService;

@Controller
public class SpecialMarketCategoryController {

	@Autowired
	private SpecialMarketCategoryService specialMarketCategoryService;

	@RequestMapping(value = "/specialmarket", method = RequestMethod.GET)
	public String displaySpecialMarketPage(Model model) {
		model.addAttribute("listSpecialMarketCategory", specialMarketCategoryService.getAllMarketCategory());
		return "admin/specialmarket.html";

	}

	@RequestMapping(value = "/createspecialmarketcat", method = RequestMethod.GET)
	public String createSpecialMarketCategory(Model model) {
		final SpecialMarketCategory specialMarketCategory = new SpecialMarketCategory();
		model.addAttribute("specialMarketCategory", specialMarketCategory);
		return "admin/createspecialmarketcat.html";

	}

	@RequestMapping(value = "/saveCategoryForSpecial", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("specialMarketCategory") SpecialMarketCategory specialMarketCategory) {
		specialMarketCategoryService.createCategory(specialMarketCategory);
		return "redirect:/createspecialmarketcat";
	}

	@RequestMapping(value = "/deleteFromSpecial", method = RequestMethod.GET)
	public String deleteMarket(@RequestParam(name = "id") Long id) {
		specialMarketCategoryService.deleteMarketById(id);
		return "redirect:/specialmarket";
	}
}
