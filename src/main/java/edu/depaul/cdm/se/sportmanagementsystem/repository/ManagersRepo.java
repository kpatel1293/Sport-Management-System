package edu.depaul.cdm.se.sportmanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.depaul.cdm.se.sportmanagementsystem.entity.ManagersEntity;



public interface ManagersRepo extends JpaRepository<ManagersEntity, Integer> 
 {
	
	

}
