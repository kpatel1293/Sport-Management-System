package edu.depaul.cdm.se.sportmanagementsystem.jack.injuries;

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
	@GetMapping
	public ResponseEntity<Injury> getInjuryById(@PathVariable(name = "id") int id) {
		Injury injury = injuryService.getInjuryById(id);
		return ResponseEntity.ok().body(injury);
	}
	
	// get date by player id
	@GetMapping
	public ResponseEntity<List<Injury>> getInjuriesByPlayerId(@PathVariable(name = "playerId") int playerId) {
		List<Injury> injuries = new ArrayList<>();
		injuryService.getInjuriesByPlayerId(playerId).forEach(injuries::add); // TODO - efficient ..?
		return ResponseEntity.ok().body(injuries);
	}
	
	// save new injury
	@PostMapping
	public ResponseEntity<Team> addInjury(@Valid @RequestBody Injury injury) {
		injuryService.addInjury(injury);
		return ResponseEntity.ok().body(injuryService.addInjury(injury));
	}
	
	// delete injury by id
	@DeleteMapping("/{id}") // TODO - This @DeleteMapping okay?
	public void deleteInjuryById(@PathVariable int id) {
		injuryService.deleteInjuryById(id);
	}
}
