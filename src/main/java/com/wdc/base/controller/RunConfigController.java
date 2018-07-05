package com.wdc.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wdc.base.repository.entity.RunConfiguration;
import com.wdc.base.service.RunConfigurationService;

@Controller
public class RunConfigController {
	
	@Autowired
	private RunConfigurationService service;
	
	
	@GetMapping(path = "/rc/landing")
	public String landingPage(Model model) {
		return "rclanding";
	}
	
	public String add(RunConfiguration configuration) {
		service.add(configuration);
		return "redirect:/rc/landing";
	}

}
