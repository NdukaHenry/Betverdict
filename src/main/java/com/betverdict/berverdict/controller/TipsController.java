package com.betverdict.berverdict.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.betverdict.berverdict.entities.Tips;
import com.betverdict.berverdict.services.ProductsService;
import com.betverdict.berverdict.services.TipsService;

@Controller
public class TipsController {



	@Autowired
	private TipsService tipsService;

	@Autowired
	private ProductsService productsService;

	@RequestMapping(value = "/displaycreatetipsform", method = RequestMethod.GET)
	public String showCreateTipForm(Model model) {
		final Tips tips = new Tips();
		model.addAttribute("tips", tips);
		model.addAttribute("listProducts", productsService.getAllProductsCategory());
		return "admin/createtips.html";
	}

	@RequestMapping(value = "/savetip", method = RequestMethod.POST)
	public String saveTip(@ModelAttribute("tips") Tips tips) {
		tipsService.createTip(tips);
		return "redirect:/displaycreatetipsform";
	}


	@RequestMapping(value = "/updatetip", method = RequestMethod.POST)
	public String tipUpdate(@RequestParam(name = "id") Long id, @ModelAttribute("tips") Tips tips
	) {

		tipsService.createTip(tips);

		System.out.println("UPDATED SUCCESSFUL" + tips.getId());
		return "redirect:/displayalltips";
	}

	@RequestMapping(value = "/displayalltips", method = RequestMethod.GET)
	public String showAllTips(Model model) {
		model.addAttribute("listTips", tipsService.getAllTips());
		return "admin/managetips.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/showformfortipupdate")
	public String showUpdateTipForm(@RequestParam(name = "id") Long id, Model model) {

		final Tips tips = tipsService.getTipById(id);

		model.addAttribute("tips", tips);
		model.addAttribute("listProducts", productsService.getAllProductsCategory());
		return "admin/updatetipform.html";
	}

	@RequestMapping(value = "/tipdelete", method = RequestMethod.GET)
	public String deleteTip(@RequestParam(name = "id") Long id) {
		tipsService.deleteTipById(id);
		return "redirect:/displayalltips";
	}

	@RequestMapping(value = "/clientpage", method = RequestMethod.GET)
	public String showAllCurrentTips(Model model) throws ParseException {
		model.addAttribute("listCurrentTips", tipsService.getCurrentTips());
		model.addAttribute("listPreviousTips", tipsService.getPastTips());
		model.addAttribute("listNextTips", tipsService.getFutureTips());
		return "client/homepage.html";
	}
}
