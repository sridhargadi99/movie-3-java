/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;

@Service 
public class MovieJpaService implements MovieRepository{
    @Autowired 
    private MovieJpaRepository movieJpaRepository;

    @Override 
    public ArrayList<Movie> allMovies(){
        List<Movie> movieCollection = movieJpaRepository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(movieCollection);
        return movies;
    }

    @Override 
    public Movie createMovie(Movie movie){
        movieJpaRepository.save(movie);
        return movie;
    }

    @Override 
    public Movie getMovie(int movieId){
        try{
            Movie movieDetails = movieJpaRepository.findById(movieId).get();
            return movieDetails;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Movie updateMovie(int movieId, Movie movie){
        try{
            Movie newMovie = movieJpaRepository.findById(movieId).get();
            if(movie.getMovieName() != null){
                newMovie.setMovieName(movie.getMovieName());
            }
            if(movie.getLeadActor() != null){
                newMovie.setLeadActor(movie.getLeadActor());
            }
            movieJpaRepository.save(newMovie);
            return newMovie;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public void deleteMovie(int movieId){
        try{
            movieJpaRepository.deleteById(movieId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}
