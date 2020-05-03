package edu.depaul.cdm.se.sportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.se.sportmanagementsystem.model.GameSchedule;

@Repository
public interface GameScheduleRepository extends JpaRepository<GameSchedule, Long> {
    
}