package com.metaphorce.cinemagic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hall;

    @Column(name = "seat_row")
    private String row;

    private Integer number;

    public Seat() {
    }

    public Seat(Long id, Integer hall, String row, Integer number) {
        this.id = id;
        this.hall = hall;
        this.row = row;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

