package edu.depaul.cdm.se.sportmanagementsystem.injuries;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/injuries")
public class InjuryController {
	
	@Autowired 
	private InjuryService injuryService;
	
	// get all injuries
	@GetMapping // TODO - @GetMapping("/injuries") ??
	public List<Injury> getAllInjuries(){
		return injuryService.getAllInjuries();
	}
	
	// get date by id
	@GetMapping("/{id}")
	public ResponseEntity<Injury> getInjuryById(@PathVariable(name = "id") int id) {
		Injury injury = injuryService.getInjuryById(id);
		return ResponseEntity.ok().body(injury);
	}
	
	// get date by player id
	@GetMapping("/{playerId}")
	public ResponseEntity<List<Injury>> getInjuriesByPlayerId(@PathVariable(name = "playerId") int playerId) {
		List<Injury> injuries = new ArrayList<>();
		injuryService.getInjuryByPlayerId(playerId).forEach(injuries::add); // TODO - efficient ..?
		return ResponseEntity.ok().body(injuries);
	}
	
	// save new injury
	@PostMapping
	public ResponseEntity<Injury> addInjury(@Valid @RequestBody Injury injury) {
		Injury i = injuryService.addInjury(injury);
		return ResponseEntity.ok().body(i);
	}
	
	// delete injury by id
	@DeleteMapping("/{id}") // TODO - This @DeleteMapping okay?
	public void deleteInjuryById(@PathVariable int id) {
		injuryService.deleteInjuryById(id);
	}
}
