package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long userId);
    List<Rating> findByMovieId(Long movieId);
    List<Rating> findByUserIdAndMovieId(Long userId, Long movieId);

}
