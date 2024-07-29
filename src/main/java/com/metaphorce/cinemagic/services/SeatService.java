package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Seat;
import com.metaphorce.cinemagic.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements SeatServiceI {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getSeatsByHallId(Long hallId) {
        return seatRepository.findByHallId(hallId);
    }

    @Override
    public Seat getSeat(Long hallId, String seatRow, Integer number) {
        return seatRepository.findByHallIdAndSeatRowAndNumber(hallId, seatRow, number);
    }
}
