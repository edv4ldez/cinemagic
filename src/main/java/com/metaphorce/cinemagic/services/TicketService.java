package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Ticket;
import com.metaphorce.cinemagic.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TicketService implements TicketServiceI {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        Optional<Ticket> existingTicket = ticketRepository.findByUserIdAndScheduleIdAndSeatId(
                ticket.getUser().getId(),
                ticket.getSchedule().getId(),
                ticket.getSeat().getId()
        );

        if (existingTicket.isPresent()) {
            throw new DataIntegrityViolationException("Ticket already exists for the user, schedule, and seat.");
        }

        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

