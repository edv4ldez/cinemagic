package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Ticket;
import com.metaphorce.cinemagic.entities.User;
import com.metaphorce.cinemagic.services.TicketService;
import com.metaphorce.cinemagic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final UserService userService;


    @Autowired
    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id) {
        Optional<Ticket> ticketOptional = ticketService.findTicketById(id);
        return ticketOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.findAllTickets();
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Optional<User> foundUserOptional = userService.getUserById(ticket.getUser().getId());
        if (foundUserOptional.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Handle user not found scenario
        }
        User foundUser = foundUserOptional.get();
        ticket.setUser(foundUser);
        Ticket savedTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}

