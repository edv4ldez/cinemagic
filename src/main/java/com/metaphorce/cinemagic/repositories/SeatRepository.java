package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByHallId(Long hallId);
    Seat findByHallIdAndSeatRowAndNumber(Long hallId, String seatRow, Integer number);
}
