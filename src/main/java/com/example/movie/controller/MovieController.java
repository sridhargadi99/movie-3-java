/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

@RestController
public class MovieController{
    @Autowired 
    private MovieJpaService service;

    @GetMapping("/movies")
    public ArrayList<Movie> allMovies(){
        return service.allMovies();
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie){
        return service.createMovie(movie);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable("movieId") int movieId){
        return service.getMovie(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie){
        return service.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId){
        service.deleteMovie(movieId);
    }
}