package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Rating;
import com.metaphorce.cinemagic.repositories.RatingRepository;
import com.metaphorce.cinemagic.services.RatingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService implements RatingServiceI {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Optional<Rating> getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByMovieId(Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    @Override
    public Rating getRatingByUserAndMovie(Long userId, Long movieId) {
        return ratingRepository.findByUserIdAndMovieId(userId, movieId);
    }

    @Override
    public Rating updateRating(Long id, Rating rating) {
        if (ratingRepository.existsById(id)) {
            rating.setId(id);
            return ratingRepository.save(rating);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
