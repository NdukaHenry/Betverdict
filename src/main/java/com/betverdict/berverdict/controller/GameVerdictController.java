package com.betverdict.berverdict.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.betverdict.berverdict.dto.VerdictAnalysisListCompiler;
import com.betverdict.berverdict.entities.VerdictAnalysis;
import com.betverdict.berverdict.services.GameVerdictService;

@Controller
public class GameVerdictController {
	@Autowired
	private GameVerdictService gameVerdictService;



	@RequestMapping(value = "/displaygameverdictformA", method = RequestMethod.GET)
	public String showStatisticsTipFormA(Model model) {
		final VerdictAnalysisListCompiler verdictAnalysisListCompiler = new VerdictAnalysisListCompiler();
		for (int i = 1; i <= 2; i++) {
			verdictAnalysisListCompiler.addAnalysisToList(new VerdictAnalysis());
		}

		model.addAttribute("formList", verdictAnalysisListCompiler);
		return "admin/creategameverdict2.html";
	}

	/**
	 * @RequestMapping("/displaygameverdictformB") public String
	 * showStatisticsTipFormB(Model model) { final GameVerdict gameVerdict = new
	 * GameVerdict(); model.addAttribute("gameVerdict", gameVerdict); return
	 * "admin/creategameverdict2.html"; }
	 **/

	@RequestMapping(value = "/saveGameVerdict", method = RequestMethod.POST)
	public String saveCategory(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("team1Name") String team1Name,
			@RequestParam("team2Name") String team2Name,
			@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
			@RequestParam("verdict") String verdict,
			@ModelAttribute("formList") VerdictAnalysisListCompiler verdictAnalysisListCompiler) {




		gameVerdictService.createGameVerdict(date, team1Name, team2Name, file1, file2,
				verdictAnalysisListCompiler.getAnalysisList(), verdict);

		return "redirect:/displaygameverdictform";
	}

	@RequestMapping(value = "/displaygameverdicts", method = RequestMethod.GET)
	public String showGameVerdicts(Model model) {
		model.addAttribute("listAllGameVerdicts", gameVerdictService.getAllGameVerdicts());
		return "admin/viewgameverdicts.html";

	}
}
