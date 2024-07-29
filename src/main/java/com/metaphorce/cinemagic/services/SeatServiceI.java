package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatServiceI {
    Seat saveSeat(Seat seat);
    List<Seat> getSeatsByHallId(Long hallId);
    Seat getSeat(Long hallId, String seatRow, Integer number);
}
