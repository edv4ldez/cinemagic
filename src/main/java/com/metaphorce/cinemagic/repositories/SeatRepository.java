package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByHall(Integer hall);
    List<Seat> findByRowAndNumber(String row, Integer number);
}
