package edu.depaul.cdm.se.sportmanagementsystem.teams;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
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
	
	public void updateTeam(Team team) {
		teamRepository.save(team);
	}
	
	public void deleteTeam(String id) {
		teamRepository.deleteById(id);
	}

	public void getTeam(String id) {
		teamRepository.findById(id);
	}
}