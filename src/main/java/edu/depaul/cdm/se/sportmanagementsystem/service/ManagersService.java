package edu.depaul.cdm.se.sportmanagementsystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.entity.ManagersEntity;
import edu.depaul.cdm.se.sportmanagementsystem.repository.ManagersRepo;



@Service
@Transactional
public class ManagersService {
	@Autowired
	ManagersRepo iManagersRepository;

	public List<ManagersEntity> findAll() {
		return iManagersRepository.findAll();
	}


}
