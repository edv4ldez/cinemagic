package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketServiceI {
    Ticket saveTicket(Ticket ticket);
    Optional<Ticket> findTicketById(Long id);
    List<Ticket> findAllTickets();
    void deleteTicket(Long id);
}

