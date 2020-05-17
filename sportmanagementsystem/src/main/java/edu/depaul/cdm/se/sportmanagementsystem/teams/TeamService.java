package edu.depaul.cdm.se.sportmanagementsystem.teams;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.teamrecord.TeamRecord;
import edu.depaul.cdm.se.sportmanagementsystem.teamrecord.TeamRecordRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	TeamRecordRepository teamRecordRepository;
	
	public List<Team> getAllTeams() {
		List<Team> teams = new ArrayList<>();
		teamRepository.findAll().forEach(teams::add);
		return teams;
	}	

	public Team getTeam(String id) {
		return teamRepository.findById(id).get();
	}
	
	public Team addTeam(Team team) {
		Team t = teamRepository.save(team);	
		TeamRecord teamRecord = new TeamRecord();
		teamRecord.setTeam(t);
		
		return t;
	}
	

	public void deleteTeam(String id) {
		teamRepository.deleteById(id);
	}
}
