package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Rating;
import com.metaphorce.cinemagic.entities.Ticket;
import com.metaphorce.cinemagic.entities.User;
import com.metaphorce.cinemagic.services.RatingService;
import com.metaphorce.cinemagic.services.TicketService;
import com.metaphorce.cinemagic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final UserService userService;

    @Autowired
    public RatingController(RatingService ratingService, TicketService ticketService, UserService userService) {
        this.ratingService = ratingService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Optional<User> foundUserOptional = userService.getUserById(rating.getUser().getId());
        if (foundUserOptional.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Handle user not found scenario
        }
        User foundUser = foundUserOptional.get();
        rating.setUser(foundUser);
        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rating>> getRatingById(@PathVariable Long id) {
        return ResponseEntity.ok(ratingService.getRatingById(id));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Rating>> getRatingsByMovieId(@PathVariable Long movieId) {
        return ResponseEntity.ok(ratingService.getRatingsByMovieId(movieId));
    }

    @GetMapping("/user/{userId}/movie/{movieId}")
    public ResponseEntity<List<Rating>> getRatingByUserAndMovie(@PathVariable Long userId, @PathVariable Long movieId) {
        return ResponseEntity.ok(ratingService.getRatingByUserAndMovie(userId, movieId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.updateRating(id, rating));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
