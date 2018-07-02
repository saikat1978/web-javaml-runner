package com.wdc.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysMonController {
	
	@GetMapping(path = "/sm/landing")
	public String landingPage(Model model) {
		return "sysmon";
	}

}
