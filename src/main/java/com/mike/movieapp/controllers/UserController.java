package com.mike.movieapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mike.movieapp.models.LoginUser;
import com.mike.movieapp.models.User;
import com.mike.movieapp.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	public final UserService userServ;

	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/login/register")
	public String loginReg(@ModelAttribute("newUser") User user, Model model) {
		model.addAttribute("loginUser", new LoginUser());
		return "user/loginReg.jsp";
	}
	
	@PostMapping("/process/register")
	public String processRegistration(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.createUser(user, result);
		if(newUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/process/login")
	public String processLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User attemptingUser = userServ.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/user/loginReg.jsp";
		}
		session.setAttribute("user_id", attemptingUser.getId());
		return"redirect:/";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/users/login/register";
	}

}
