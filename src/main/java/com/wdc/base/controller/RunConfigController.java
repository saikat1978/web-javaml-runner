package com.wdc.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RunConfigController {
	
	@GetMapping(path = "/rc/landing")
	public String landingPage(Model model) {
		return "rclanding";
	}

}
