package edu.depaul.cdm.se.sportmanagementsystem.teams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	public List<Team> getAllTeams() {
		
		List<Team> teams = new ArrayList<>();
		teamRepository.findAll()
		.forEach(teams::add);
		return teams;
		
	}	
	
	public void addTeam(Team team) {
		teamRepository.save(team);
		
	}
	
	
	public void updateTeam(String id, Team team) {
		teamRepository.save(team);
	}
	
	public void deleteTeam(String id) {
		teamRepository.deleteById(id);
	}

	public Optional<Team> getTeam(String id) {
		return teamRepository.findById(id);
	}
}
