package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByUserIdAndScheduleIdAndSeatId(Long userId, Long scheduleId, Long seatId);
}


