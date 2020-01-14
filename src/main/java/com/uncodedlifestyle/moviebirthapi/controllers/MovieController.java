package com.uncodedlifestyle.moviebirthapi.controllers;

import com.uncodedlifestyle.moviebirthapi.models.MovieModel;
import com.uncodedlifestyle.moviebirthapi.models.Movies;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {


    @RequestMapping("/movie")
    public List<Object> getMovieBirth(@RequestParam("birth") String birth) throws Exception{
        String key = System.getenv().get("API_KEY");
        RestTemplate restTemplate;
        String release_year = "&primary_release_year=";
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + key + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
        //birthYear is only getting the year of birth, example: 2020-09-14 = 2020
        if(birth.equals("")){
            birth = "2020-09-14";
        }
        String birthYear = birth.substring(0,4);
        restTemplate = new RestTemplate();
        MovieModel movies = restTemplate.getForObject(url + release_year + birthYear, MovieModel.class);

        return dateComparing(birth, movies);
    }

    private List<Object> dateComparing(String userBirth, MovieModel movieDate) throws Exception{
        String date;
        String month = userBirth.substring(5,7);
        Movies birthdayMovie = new Movies();
        List<Movies> monthMovie = new ArrayList<>();
        List<Movies> yearMovie = new ArrayList<>();
        for(int i = 0; i < movieDate.getResults().size(); i++){
            date = movieDate.getResults().get(i).getRelease_date();
            if(userBirth.equals(date)) { //I'm comparing the dates to see what movie released on your birthday
                birthdayMovie = movieDate.getResults().get(i);
            }else if( month.equals(date.substring(5,7))){ //Here I'm comparing the months to return movies in your birth month
                monthMovie.add(movieDate.getResults().get(i));
            }else { // The else will just show movies that were released in your birth year.
                yearMovie.add(movieDate.getResults().get(i));
            }

        }
        return Arrays.asList(birthdayMovie, monthMovie, yearMovie);
    }

}
