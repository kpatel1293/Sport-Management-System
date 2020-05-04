package edu.depaul.cdm.se.sportmanagementsystem.alex.teams;

import java.util.ArrayList;
import java.util.List;

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
	
	public Team addTeam(Team team) {
		return teamRepository.save(team);	
	}
	
	
	public Team updateTeam(int id, Team team) {
		return teamRepository.save(team);
	}
	
	public void deleteTeam(int id) {
		teamRepository.deleteById(id);
	}

	public Team getTeam(int id) {
		return teamRepository.findById(id).get();
	}
}
