package com.betverdict.berverdict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.betverdict.berverdict.services.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;


	@RequestMapping("/test")
	public String showAllAdmins(Model model) {
		model.addAttribute("ListAdmin", adminService.getAllAdmin());
		return "test/test.html";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String home() {
		return "admin/index.html";
	}










}
