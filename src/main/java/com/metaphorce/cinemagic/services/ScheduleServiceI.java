package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Schedule;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ScheduleServiceI {
    Schedule saveSchedule(Schedule schedule);
    Optional<Schedule> getScheduleById(Long id);
    List<Schedule> getAllSchedules();
    List<Schedule> getSchedulesByMovieId(Long movieId);
    List<Schedule> getSchedulesByDate(Date date);
    List<Schedule> getSchedulesByHall(Integer hall);
    void deleteScheduleById(Long id);
}
