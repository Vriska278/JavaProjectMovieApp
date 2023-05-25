package com.mike.movieapp.services;

import java.util.LinkedHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mike.movieapp.models.Movie;

@Service
public class ApiService {
    private static final String MOVIE_API_URL = "https://api.themoviedb.org/3/movie/550?api_key=cc5f968a4f7ae933197e0ea27fb47f06";
    private static final String MOVIE_API_BASE_SEARCH = "https://api.themoviedb.org/3/search/movie?query=";
    private static final String API_KEY_SEARCH = "&api_key=cc5f968a4f7ae933197e0ea27fb47f06&include_adult=false&language=en-US&page=1";


    public Movie fetchMovie() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate.getForEntity(MOVIE_API_URL, Movie.class);
        return response.getBody();
    }
    
    public LinkedHashMap searchMovies(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = MOVIE_API_BASE_SEARCH + query + API_KEY_SEARCH;
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(url, LinkedHashMap.class);
        return response.getBody();
    }
    
    
//    public List<Movie> fetchAll(){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Movie> response = restTemplate.getForEntity(MOVIE_API_URL, Movie.class);
//        return response.getBody();
//    }
}