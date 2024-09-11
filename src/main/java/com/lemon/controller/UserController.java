package com.lemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lemon.model.User;
import com.lemon.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/login", })
	public String getLogin() {
		return "LoginForm";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, org.springframework.ui.Model model,HttpSession session) {
		session.setAttribute("validUser", user);
		session.setMaxInactiveInterval(10*60);
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

		User usr = userService.userLogin(user.getEmail(), user.getPassword());

		if (usr != null) {
			
			if(usr.getRole().equalsIgnoreCase("ADMIN")) {
				
				return "Home";
			}

			model.addAttribute("uname", usr.getFname());

			return "UserHome";
		}
		model.addAttribute("error", "user not exist");
		return "LoginForm";
	}

	@GetMapping("/signup")
	public String getSignup() {
		return "SignupForm";
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User u) {

		u.setRole("USER");
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		userService.userSignup(u);

		return "LoginForm";
	}

	@GetMapping("/logout")
	public String logout() {

		return "LoginForm";
	}
}
