package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Hall;
import com.metaphorce.cinemagic.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService implements HallServiceI {

    @Autowired
    private HallRepository hallRepository;

    @Override
    public Hall saveHall(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public Hall getHallById(Long id) {
        Optional<Hall> optionalHall = hallRepository.findById(id);
        return optionalHall.orElse(null);
    }

    @Override
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public Hall updateHall(Long id, Hall hall) {
        if (hallRepository.existsById(id)) {
            hall.setId(id);
            return hallRepository.save(hall);
        }
        return null;
    }

    @Override
    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }
}
