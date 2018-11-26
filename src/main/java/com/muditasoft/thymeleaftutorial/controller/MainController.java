package com.muditasoft.thymeleaftutorial.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView homePage() {
		Map<String, Object> models = new HashMap<>();
		models.put("username", "Tutku Ince");
		models.put("id", 111);
		
		return new ModelAndView("homepage", "model", models);
	}

	@RequestMapping("/profile")
	public String viewProfile(Model model) {
		Map<String, Object> models = new HashMap<>();
		models.put("title", "Mr");
		models.put("firstName", "Tutku");
		models.put("lastName", "Ince");
		models.put("dateOfBirth", new GregorianCalendar(1989, 1, 15));
		models.put("description", "a <strong>fantastic</strong> Java programmer");

		model.addAttribute("model", models);
		
		List<String> languages = new ArrayList<>();
		languages.add("English");
		languages.add("Russian");
		languages.add("Turkish");
		
		models.put("languages", languages);
		
		models.put("color", "#ccc");

		return "profile";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		
		return "newUser";
	}
}
