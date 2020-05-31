package edu.depaul.cdm.se.sportmanagementsystem.managers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.se.sportmanagementsystem.user.User;

@Repository
public interface ManagersRepository extends JpaRepository<Managers, Long> {
    Managers findByUser(User user);
}