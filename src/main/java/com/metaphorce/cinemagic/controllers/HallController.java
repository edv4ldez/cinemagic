package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Hall;
import com.metaphorce.cinemagic.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @PostMapping
    public ResponseEntity<Hall> createHall(@RequestBody Hall hall) {
        Hall savedHall = hallService.saveHall(hall);
        return ResponseEntity.ok(savedHall);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable Long id) {
        Hall hall = hallService.getHallById(id);
        if (hall != null) {
            return ResponseEntity.ok(hall);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Hall>> getAllHalls() {
        List<Hall> halls = hallService.getAllHalls();
        return ResponseEntity.ok(halls);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hall> updateHall(@PathVariable Long id, @RequestBody Hall hall) {
        Hall updatedHall = hallService.updateHall(id, hall);
        if (updatedHall != null) {
            return ResponseEntity.ok(updatedHall);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
        return ResponseEntity.noContent().build();
    }
}
