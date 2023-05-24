package com.mike.movieapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mike.movieapp.models.Movie;
import com.mike.movieapp.services.ApiService;

@Controller
public class ApiController {
	
	public final ApiService apiServ;

	public ApiController(ApiService apiServ) {
		// TODO Auto-generated constructor stub
		this.apiServ = apiServ;
	}
	
	@GetMapping("/api")
	public String apiTest(Model model) {
		Movie movie = apiServ.fetchMovie();
		model.addAttribute("movie", movie);
		System.out.println(movie.getTitle());
		System.out.println(movie.getOverview());
		System.out.println(movie.getPoster_path());
		return "movie/test.jsp";
	}

}
