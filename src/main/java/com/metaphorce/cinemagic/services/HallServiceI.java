package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Hall;
import java.util.List;

public interface HallServiceI {
    Hall saveHall(Hall hall);
    Hall getHallById(Long id);
    List<Hall> getAllHalls();
    Hall updateHall(Long id, Hall hall);
    void deleteHall(Long id);
}
