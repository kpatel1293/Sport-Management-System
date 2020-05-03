package edu.depaul.cdm.se.sportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.se.sportmanagementsystem.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}