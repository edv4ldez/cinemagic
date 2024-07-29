package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Seat;
import com.metaphorce.cinemagic.services.SeatServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatServiceI seatService;

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat savedSeat = seatService.saveSeat(seat);
        return new ResponseEntity<>(savedSeat, HttpStatus.CREATED);
    }

    @GetMapping("/hall/{hallId}")
    public ResponseEntity<List<Seat>> getSeatsByHallId(@PathVariable Long hallId) {
        List<Seat> seats = seatService.getSeatsByHallId(hallId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/{hallId}/{seatRow}/{number}")
    public ResponseEntity<Seat> getSeat(
            @PathVariable Long hallId,
            @PathVariable String seatRow,
            @PathVariable Integer number) {
        Seat seat = seatService.getSeat(hallId, seatRow, number);
        if (seat != null) {
            return new ResponseEntity<>(seat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
