package com.mike.movieapp.controllers;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mike.movieapp.models.Movie;
import com.mike.movieapp.services.ApiService;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	public final ApiService apiServ;

	public ApiController(ApiService apiServ) {
		// TODO Auto-generated constructor stub
		this.apiServ = apiServ;
	}
	
	@GetMapping("/")
	public String apiTest(Model model) {
		Movie movie = apiServ.fetchMovie();
		model.addAttribute("movie", movie);
		return "movie/test.jsp";
	}
	
	@GetMapping("/results/{query}")
	public String displayApiResults(@PathVariable("query") String query, Model model) {
		LinkedHashMap test = apiServ.searchMovies(query);
		Object resultData = test.get("results");
		model.addAttribute("list", resultData);
		return "movie/search.jsp";
	}

}
