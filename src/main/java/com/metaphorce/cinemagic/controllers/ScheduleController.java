package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Schedule;
import com.metaphorce.cinemagic.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") Long id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Schedule>> getSchedulesByMovieId(@PathVariable("movieId") Long movieId) {
        List<Schedule> schedules = scheduleService.getSchedulesByMovieId(movieId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Schedule>> getSchedulesByDate(@PathVariable("date") LocalDate date) {
        List<Schedule> schedules = scheduleService.getSchedulesByDate(date);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/hall/{hallId}")
    public ResponseEntity<List<Schedule>> getSchedulesByHallId(@PathVariable("hallId") Long hallId) {
        List<Schedule> schedules = scheduleService.getSchedulesByHallId(hallId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("id") Long id, @RequestBody Schedule schedule) {
        Schedule updatedSchedule = scheduleService.updateSchedule(id, schedule);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Long id) {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
