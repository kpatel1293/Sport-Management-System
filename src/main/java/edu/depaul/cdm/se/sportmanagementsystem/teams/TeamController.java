package edu.depaul.cdm.se.sportmanagementsystem.teams;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class TeamController {
	
	@Autowired 
	private TeamService teamService;
	
	@RequestMapping("/teams")
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/teams")
	public void addTeam(@RequestBody Team team) {
		teamService.addTeam(team);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value = "/teams/{id}")
	public void deleteTeam(@PathVariable String id) {
		teamService.deleteTeam(id);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value = "/teams/{id}")
	public void updateTeam(@PathVariable String id, @RequestBody Team team) {
		teamService.updateTeam(id, team);
	}
	
	@RequestMapping("/teams/{id}")
	public Optional<Team> getTeam(String id) {
		  return teamService.getTeam(id);
		
	
	}
	
	
	

}
