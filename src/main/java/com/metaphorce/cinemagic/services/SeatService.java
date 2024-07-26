package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Seat;
import com.metaphorce.cinemagic.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService implements SeatServiceI {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public List<Seat> getSeatsByHall(Integer hall) {
        return seatRepository.findByHall(hall);
    }

    @Override
    public List<Seat> getSeatsByRowAndNumber(String row, Integer number) {
        return seatRepository.findByRowAndNumber(row, number);
    }

    @Override
    public void deleteSeatById(Long id) {
        seatRepository.deleteById(id);
    }
}
