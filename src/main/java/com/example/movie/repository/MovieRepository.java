// Write your code here
package com.example.movie.repository;

import com.example.movie.model.Movie;
import java.util.*;

public interface MovieRepository{
    ArrayList<Movie> allMovies();
    Movie createMovie(Movie movie);
    Movie getMovie(int movieId);
    Movie updateMovie(int movieId, Movie movie);
    void deleteMovie(int movieId);
    
}