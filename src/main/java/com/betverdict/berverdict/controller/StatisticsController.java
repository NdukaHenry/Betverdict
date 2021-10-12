package com.betverdict.berverdict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.betverdict.berverdict.entities.Statistics;
import com.betverdict.berverdict.services.StatisticsService;

@Controller
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;

	@RequestMapping(value = "/displaystatisticsform", method = RequestMethod.GET)
	public String showStatisticsTipForm(Model model) {
		final Statistics statistics = new Statistics();
		model.addAttribute("statistics", statistics);
		return "admin/createstatisticstype.html";
	}

	@RequestMapping(value = "/saveStatisticsType", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("statistics") Statistics statistics) {
		statisticsService.createStat(statistics);
		return "redirect:/displaystatisticsform";
	}

	@RequestMapping(value = "/displaystatistics", method = RequestMethod.GET)
	public String displayStatistics(Model model) {
		model.addAttribute("listStatistics", statisticsService.getAllStatistics());
		return "admin/viewstatistics.html";

	}

	@RequestMapping(value = "/deleteFromStatistics", method = RequestMethod.GET)
	public String deleteMarket(@RequestParam(name = "id") Long id) {
		statisticsService.deleteStatisticsById(id);
		return "redirect:/displaystatistics";
	}
}
