package com.uncodedlifestyle.moviebirthapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel {
    private List<Movies> results;

    public MovieModel(){

    }

    public MovieModel(List<Movies> results) {
        this.results = results;

    }

    public List<Movies> getResults() {
        return results;
    }

}
