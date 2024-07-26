package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);

    List<Movie> findByGenre(String genre);

    List<Movie> findByDirector(String director);
}
