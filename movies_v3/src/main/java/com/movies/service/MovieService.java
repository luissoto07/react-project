package com.movies.service;

import com.movies.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMovies();
    Movie getMovie(Integer id);
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie, Integer id);
    void deleteMovie(Integer id);
}
