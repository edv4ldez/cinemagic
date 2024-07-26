package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatServiceI {
    Seat saveSeat(Seat seat);
    Optional<Seat> getSeatById(Long id);
    List<Seat> getAllSeats();
    List<Seat> getSeatsByHall(Integer hall);
    List<Seat> getSeatsByRowAndNumber(String row, Integer number);
    void deleteSeatById(Long id);
}
