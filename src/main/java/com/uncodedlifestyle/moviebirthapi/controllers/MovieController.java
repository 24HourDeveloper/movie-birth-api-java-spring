package com.uncodedlifestyle.moviebirthapi.controllers;

import com.uncodedlifestyle.moviebirthapi.models.MovieModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @RequestMapping("/api/movie")
    public MovieModel getMovieBirth(){
        return new MovieModel("Batman", "image", "The movie of a vigilanty hero.","10212001");
    }
}
