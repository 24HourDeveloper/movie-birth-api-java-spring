package com.uncodedlifestyle.moviebirthapi;

import com.uncodedlifestyle.moviebirthapi.models.MovieModel;
import com.uncodedlifestyle.moviebirthapi.models.Movies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class MovieBirthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBirthApiApplication.class, args);
	}
}
