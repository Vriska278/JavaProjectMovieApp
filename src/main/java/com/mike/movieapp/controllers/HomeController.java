package com.mike.movieapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mike.movieapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	private final UserService userServ;
	public HomeController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/")
	public String home(HttpSession session,Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("loggedInUser", userServ.getOne(userId));
		return "main/home.jsp";
	}

}
