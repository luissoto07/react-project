package com.movies.controller;

import com.movies.entity.Movie;
import com.movies.reposority.MovieRepo;
import com.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping("/get_all")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok().body(movieService.getMovies());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable(name="id") Integer id){
        if(!movieRepo.existsById(id)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(movieService.getMovie(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable(name="id") Integer id){
        return ResponseEntity.ok().body(movieService.updateMovie(movie, id));
    }
    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable(name="id") Integer id){
        if(!movieRepo.existsById(id)){
            return ResponseEntity.badRequest().build();
        }
        movieRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
