package com.lemon.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {
	@GetMapping("/userhome")
	public String getGallery(Model model) {
		
		
		
		return "UserHome";
	}
    
}


