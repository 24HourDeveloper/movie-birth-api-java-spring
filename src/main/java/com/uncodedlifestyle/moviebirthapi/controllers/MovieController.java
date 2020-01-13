package com.uncodedlifestyle.moviebirthapi.controllers;

import com.uncodedlifestyle.moviebirthapi.models.MovieModel;
import com.uncodedlifestyle.moviebirthapi.models.Movies;
import com.uncodedlifestyle.moviebirthapi.secure.Secure;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private Secure secure = new Secure();

    @RequestMapping("/movie")
    public List<Movies> getMovieBirth(@RequestParam("birth") String birth) throws Exception{
        RestTemplate restTemplate;
        String release_year = "&primary_release_year=";
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + secure.getAPI() + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";

        restTemplate = new RestTemplate();
        MovieModel movies = restTemplate.getForObject(url + release_year + birth, MovieModel.class);
        return  movies.getResults();
    }

}
