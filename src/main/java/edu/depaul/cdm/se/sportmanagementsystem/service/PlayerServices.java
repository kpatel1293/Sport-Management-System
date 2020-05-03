package edu.depaul.cdm.se.sportmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.entity.PlayerEntity;
import edu.depaul.cdm.se.sportmanagementsystem.repository.PlayerRepo;

@Service
@Transactional
public class PlayerServices {

	@Autowired
	PlayerRepo iPlayersRepository;

	public List<PlayerEntity> findAll() {
		return iPlayersRepository.findAll();
	}
	
	public Optional<PlayerEntity> findById(Integer id) {
		return iPlayersRepository.findById(id);
	}
	
	public PlayerEntity savePlayer(PlayerEntity player) {
		return iPlayersRepository.save(player);
	}


}
