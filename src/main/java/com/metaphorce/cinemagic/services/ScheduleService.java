package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Schedule;
import com.metaphorce.cinemagic.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements ScheduleServiceI {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getSchedulesByMovieId(Long movieId) {
        return scheduleRepository.findByMovieId(movieId);
    }

    @Override
    public List<Schedule> getSchedulesByDate(Date date) {
        return scheduleRepository.findByDate(date);
    }

    @Override
    public List<Schedule> getSchedulesByHall(Integer hall) {
        return scheduleRepository.findByHall(hall);
    }

    @Override
    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
