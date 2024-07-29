package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Schedule;
import java.time.LocalDate;
import java.util.List;

public interface ScheduleServiceI {
    Schedule saveSchedule(Schedule schedule);
    Schedule getScheduleById(Long id);
    List<Schedule> getAllSchedules();
    List<Schedule> getSchedulesByMovieId(Long movieId);
    List<Schedule> getSchedulesByDate(LocalDate date);
    List<Schedule> getSchedulesByHallId(Long hallId);
    Schedule updateSchedule(Long id, Schedule schedule);
    void deleteSchedule(Long id);
}
