package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Rating;
import java.util.List;
import java.util.Optional;

public interface RatingServiceI {
    Rating createRating(Rating rating);
    Optional<Rating> getRatingById(Long id);
    List<Rating> getAllRatings();
    List<Rating> getRatingsByUserId(Long userId);
    List<Rating> getRatingsByMovieId(Long movieId);
    List<Rating> getRatingByUserAndMovie(Long userId, Long movieId);
    Rating updateRating(Long id, Rating rating);
    void deleteRating(Long id);
}
