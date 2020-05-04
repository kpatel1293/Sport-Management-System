package edu.depaul.cdm.se.sportmanagementsystem.managers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagersRepository extends JpaRepository<Managers, Long> {
    
}