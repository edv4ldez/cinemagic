package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Schedule;
import com.metaphorce.cinemagic.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        return ResponseEntity.ok(savedSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Schedule>> getSchedulesByMovieId(@PathVariable Long movieId) {
        List<Schedule> schedules = scheduleService.getSchedulesByMovieId(movieId);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Schedule>> getSchedulesByDate(@PathVariable Date date) {
        List<Schedule> schedules = scheduleService.getSchedulesByDate(date);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/hall/{hall}")
    public ResponseEntity<List<Schedule>> getSchedulesByHall(@PathVariable Integer hall) {
        List<Schedule> schedules = scheduleService.getSchedulesByHall(hall);
        return ResponseEntity.ok(schedules);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduleById(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return ResponseEntity.noContent().build();
    }
}
