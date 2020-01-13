package com.uncodedlifestyle.moviebirthapi.controllers;

import com.uncodedlifestyle.moviebirthapi.models.MovieModel;
import com.uncodedlifestyle.moviebirthapi.models.Movies;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {

    private String url = "https://api.themoviedb.org/3/discover/movie?api_key=1ad631084611d4fcc3f954f51d4378c7&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
    private RestTemplate restTemplate;

    @RequestMapping("/api/movie")
    public List<Movies> getMovieBirth(){
        restTemplate = new RestTemplate();
        MovieModel movies = restTemplate.getForObject(url, MovieModel.class);
        return  movies.getResults();
    }
}
