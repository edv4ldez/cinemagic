package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Movie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MovieServiceI {
    Movie saveMovie(Movie movie);

    Optional<Movie> getMovieById(Long id);

    List<Movie> getAllMovies();

    List<Movie> getMoviesByTitle(String title);

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> getMoviesByDirector(String director);

    void deleteMovie(Long id);
}
