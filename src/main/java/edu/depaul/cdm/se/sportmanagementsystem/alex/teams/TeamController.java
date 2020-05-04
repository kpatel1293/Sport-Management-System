package edu.depaul.cdm.se.sportmanagementsystem.alex.teams;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {
	
	@Autowired 
	private TeamService teamService;
	
	@RequestMapping
	public ResponseEntity<List<Team>> getAllTeams(){
		return ResponseEntity.ok().body(teamService.getAllTeams());
	}
	
	@PostMapping
	public ResponseEntity<Team> addTeam(@Valid @RequestBody Team team) {
		return ResponseEntity.ok().body(teamService.addTeam(team));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTeam(@PathVariable int id) {
		teamService.deleteTeam(id);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable int id, @Valid @RequestBody Team team) {
		team.setId(id);
		teamService.updateTeam(id, team);

		return ResponseEntity.ok().body(team);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Team> getTeam(@PathVariable int id) {
		Team team = teamService.getTeam(id);

		return ResponseEntity.ok().body(team);
	}
}
