package com.example.demo;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	@GetMapping("/")
	public String greeting(Model model) {
		String greetingMessage = getGreetingMessage();
		model.addAttribute("greeting", greetingMessage);
		return "welcome";
	}
	
	private String getGreetingMessage() {
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		
		if (hour < 12) {
			return "Good Morning, Blake, Welcome to COMP367";
		} else {
			return "Good Afternoon, Blake, Welcome to COMP367";
		}
	}
}

