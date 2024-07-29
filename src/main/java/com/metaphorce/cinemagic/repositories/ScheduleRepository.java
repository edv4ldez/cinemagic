package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMovieId(Long movieId);
    List<Schedule> findByDate(LocalDate date);
    List<Schedule> findByHallId(Long hallId);
}
