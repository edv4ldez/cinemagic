package com.metaphorce.cinemagic;

import com.metaphorce.cinemagic.entities.Schedule;
import com.metaphorce.cinemagic.entities.Seat;
import com.metaphorce.cinemagic.entities.Ticket;
import com.metaphorce.cinemagic.entities.User;
import com.metaphorce.cinemagic.enums.UserType;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    public void testTicketConstructorAndGetters() {
        Long id = 1L;
        User user = new User("Alice", "alice@example.com", "password123", UserType.Spectator, new Timestamp(System.currentTimeMillis()));
        Schedule schedule = new Schedule();
        Seat seat = new Seat();
        BigDecimal price = new BigDecimal("10.00");
        Timestamp purchaseDate = new Timestamp(System.currentTimeMillis());

        Ticket ticket = new Ticket(id, purchaseDate, price, seat, schedule, user);

        assertEquals(id, ticket.getId());
        assertEquals(user, ticket.getUser());
        assertEquals(schedule, ticket.getSchedule());
        assertEquals(seat, ticket.getSeat());
        assertEquals(price, ticket.getPrice());
        assertEquals(purchaseDate, ticket.getPurchaseDate());
    }

    @Test
    public void testSetters() {
        Ticket ticket = new Ticket();

        Long newId = 2L;
        User newUser = new User("Checo", "checo@example.com", "password456", UserType.Administrator, new Timestamp(System.currentTimeMillis()));
        Schedule newSchedule = new Schedule();
        Seat newSeat = new Seat();
        BigDecimal newPrice = new BigDecimal("15.00");
        Timestamp newPurchaseDate = new Timestamp(System.currentTimeMillis());

        ticket.setId(newId);
        ticket.setUser(newUser);
        ticket.setSchedule(newSchedule);
        ticket.setSeat(newSeat);
        ticket.setPrice(newPrice);
        ticket.setPurchaseDate(newPurchaseDate);

        assertEquals(newId, ticket.getId());
        assertEquals(newUser, ticket.getUser());
        assertEquals(newSchedule, ticket.getSchedule());
        assertEquals(newSeat, ticket.getSeat());
        assertEquals(newPrice, ticket.getPrice());
        assertEquals(newPurchaseDate, ticket.getPurchaseDate());
    }

    @Test
    public void testNullConstructor() {
        Ticket ticket = new Ticket();

        assertNull(ticket.getId());
        assertNull(ticket.getUser());
        assertNull(ticket.getSchedule());
        assertNull(ticket.getSeat());
        assertNull(ticket.getPrice());
        assertNull(ticket.getPurchaseDate());
    }

    @Test
    public void testNullSetters() {
        Ticket ticket = new Ticket();

        ticket.setId(null);
        ticket.setUser(null);
        ticket.setSchedule(null);
        ticket.setSeat(null);
        ticket.setPrice(null);
        ticket.setPurchaseDate(null);

        assertNull(ticket.getId());
        assertNull(ticket.getUser());
        assertNull(ticket.getSchedule());
        assertNull(ticket.getSeat());
        assertNull(ticket.getPrice());
        assertNull(ticket.getPurchaseDate());
    }
}



