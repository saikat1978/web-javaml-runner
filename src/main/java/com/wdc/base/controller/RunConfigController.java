package com.wdc.base.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wdc.base.repository.entity.RunConfiguration;
import com.wdc.base.service.RunConfigurationService;

@Controller
public class RunConfigController {
	
	private static final Logger logger = Logger.getLogger(RunConfigController.class.getName());
	
	@Autowired
	private RunConfigurationService service;
	
	
	@GetMapping(path = "/rc/landing")
	public String landingPage(Model model) {
		
		return "rclanding";
	}
	
	@PostMapping(path="/rc/add")
	public String add(RunConfiguration configuration) {
		logger.info("############ inside add");
		service.add(configuration);
		return "redirect:/rc/landing";
	}

}
