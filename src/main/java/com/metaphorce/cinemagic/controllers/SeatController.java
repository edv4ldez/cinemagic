package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Seat;
import com.metaphorce.cinemagic.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat savedSeat = seatService.saveSeat(seat);
        return ResponseEntity.ok(savedSeat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Optional<Seat> seat = seatService.getSeatById(id);
        return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/hall/{hall}")
    public ResponseEntity<List<Seat>> getSeatsByHall(@PathVariable Integer hall) {
        List<Seat> seats = seatService.getSeatsByHall(hall);
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/row/{row}/number/{number}")
    public ResponseEntity<List<Seat>> getSeatsByRowAndNumber(@PathVariable String row, @PathVariable Integer number) {
        List<Seat> seats = seatService.getSeatsByRowAndNumber(row, number);
        return ResponseEntity.ok(seats);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeatById(@PathVariable Long id) {
        seatService.deleteSeatById(id);
        return ResponseEntity.noContent().build();
    }
}
