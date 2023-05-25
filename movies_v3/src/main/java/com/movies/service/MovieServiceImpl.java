package com.movies.service;

import com.movies.entity.Movie;
import com.movies.reposority.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Movie getMovie(Integer id) {
        return movieRepo.findById(id).orElseThrow(() -> new IllegalStateException("Movie not found"));
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie, Integer id) {
        return movieRepo.findById(id).map( myMovie -> {
            myMovie.setTitle(movie.getTitle());
            myMovie.setLength(movie.getLength());
            myMovie.setCreator(movie.getCreator());

            return movieRepo.save(myMovie);
        }).orElseThrow(()->new IllegalStateException("Movie not found"));
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepo.deleteById(id);
    }
}
