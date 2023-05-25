package com.movies;

import com.movies.dto.UserDTO;
import com.movies.entity.Movie;
import com.movies.service.MovieService;
import com.movies.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class MoviesV3Application {

	public static void main(String[] args) {
		SpringApplication.run(MoviesV3Application.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, MovieService movieService){
		return args -> {
			movieService.saveMovie(new Movie(1, "Creed 3", 1.33,"Michael B. Jordan"));
			movieService.saveMovie(new Movie(2, "Super Mario Bros", 1.32,"Nintendo"));
			movieService.saveMovie(new Movie(3, "Avatar", 3.12,"James Cameron"));
			movieService.saveMovie(new Movie(4, "John Wick", 2.50,"Chad. S"));

			userService.addUser(new UserDTO(1, "Luis Soto","luis@example.com","123456"));
			userService.addUser(new UserDTO(2, "Vicky Delgadillo","vicky@example.com","123456"));
			userService.addUser(new UserDTO(3, "User_xyz","user_xyz@example.com","123456"));
			userService.addUser(new UserDTO(4, "User_abc","user_abc@example.com","123456"));

		};
	}

}
