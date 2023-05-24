package com.mike.movieapp.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mike.movieapp.models.Movie;

@Service
public class ApiService {
    private static final String MOVIE_API_URL = "https://api.themoviedb.org/3/movie/550?api_key=cc5f968a4f7ae933197e0ea27fb47f06";


    public Movie fetchMovie() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate.getForEntity(MOVIE_API_URL, Movie.class);
        return response.getBody();
    }
    
//    public List<Movie> fetchAll(){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Movie> response = restTemplate.getForEntity(MOVIE_API_URL, Movie.class);
//        return response.getBody();
//    }
}