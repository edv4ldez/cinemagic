package com.metaphorce.cinemagic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @Column(name = "seat_row", nullable = false)
    private String seatRow;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "isReserved")
    private Boolean isReserved = false;

    // Constructors
    public Seat() {
    }

    public Seat(Long id, Hall hall, String seatRow, Integer number, Boolean isReserved) {
        this.id = id;
        this.hall = hall;
        this.seatRow = seatRow;
        this.number = number;
        this.isReserved = isReserved;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(Boolean isReserved) {
        this.isReserved = isReserved;
    }
}
