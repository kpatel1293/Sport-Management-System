package edu.depaul.cdm.se.sportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.depaul.cdm.se.sportmanagementsystem.entity.PlayerEntity;

public interface PlayerRepo extends JpaRepository<PlayerEntity, Integer> 
{
	
	

}
