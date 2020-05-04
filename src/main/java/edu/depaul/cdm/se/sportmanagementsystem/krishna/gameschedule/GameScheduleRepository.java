package edu.depaul.cdm.se.sportmanagementsystem.krishna.gameschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameScheduleRepository extends JpaRepository<GameSchedule, Long> {
    
}