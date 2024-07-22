package com.metaphorce.cinemagic;

import com.metaphorce.cinemagic.entities.Movie;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void testMovieConstructor() {
        // Create sample objects
        Long id = 1L;
        String title = "Inception";
        String description = "A thief who steals corporate secrets through the use of dream-sharing technology...";
        String director = "Christopher Nolan";
        Integer duration = 148;
        String genre = "Sci-Fi";
        Date releaseDate = new Date();

        // Create a movie using the constructor
        Movie movie = new Movie(id, title, description, director, duration, genre, releaseDate);

        // Verify if the movie attributes are set correctly
        assertEquals(id, movie.getId());
        assertEquals(title, movie.getTitle());
        assertEquals(description, movie.getDescription());
        assertEquals(director, movie.getDirector());
        assertEquals(duration, movie.getDuration());
        assertEquals(genre, movie.getGenre());
        assertEquals(releaseDate, movie.getReleaseDate());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a movie with default constructor
        Movie movie = new Movie();

        // Sample values
        Long newId = 2L;
        String newTitle = "The Dark Knight";
        String newDescription = "When the menace known as The Joker emerges...";
        String newDirector = "Christopher Nolan";
        Integer newDuration = 152;
        String newGenre = "Action";
        Date newReleaseDate = new Date();

        // Set values using setters
        movie.setId(newId);
        movie.setTitle(newTitle);
        movie.setDescription(newDescription);
        movie.setDirector(newDirector);
        movie.setDuration(newDuration);
        movie.setGenre(newGenre);
        movie.setReleaseDate(newReleaseDate);

        assertEquals(newId, movie.getId());
        assertEquals(newTitle, movie.getTitle());
        assertEquals(newDescription, movie.getDescription());
        assertEquals(newDirector, movie.getDirector());
        assertEquals(newDuration, movie.getDuration());
        assertEquals(newGenre, movie.getGenre());
        assertEquals(newReleaseDate, movie.getReleaseDate());
    }
}

