package com.wdc.base.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysMonController {
	
	@GetMapping(path = "/sm/landing")
	public String landingPage(Model model) {
		return "sysmon";
	}

	@GetMapping(path = "/sm/readLog")
	public String readLog(Model model, HttpSession session) {
		String logfile = "F:\\input1.txt";
		String errfile = "F:\\err1.txt";
		StringBuilder builder = new StringBuilder();
		
		File logF = new File(logfile);
		File errF = new File(errfile);
		
		try {
			Scanner scanner = new Scanner(logF);
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine()).append("\n");
			}
			scanner.close(); 
			
			scanner = new Scanner(errF);
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine()).append("\n");
			}
			scanner.close(); 
			
			session.setAttribute("logtext", builder.toString());			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			builder.append("log files not generated. Please check the application error log.");
			return "sysmon";
		}
		return "redirect:/sm/landing";
	}
	
}
