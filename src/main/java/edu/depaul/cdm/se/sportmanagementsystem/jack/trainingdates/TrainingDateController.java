package edu.depaul.cdm.se.sportmanagementsystem.jack.trainingdates;

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
@RequestMapping("/api/v1/trainingdates")
public class TrainingdateController {
	
	@Autowired 
	private TrainingDateService trainingDateService;
	
	// get all dates
	@GetMapping // TODO - @GetMapping("/trainingdates") ??
	public List<TrainingDate> getAllTrainingDates(){
		return trainingDateService.getAllTrainingDates();
	}
	
	// get date by id
	@GetMapping
	public ResponseEntity<TrainingDate> getTrainingDateById(@PathVariable(name = "id") int id) {
		TrainingDate date = trainingDateService.getTrainingDateById(id);
		return ResponseEntity.ok().body(date);
	}
	
	// get date by team id
	@GetMapping
	public ResponseEntity<List<TrainingDate>> getTrainingDatesByTeam(@PathVariable(name = "teamId") int teamId) {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateService.getTrainingDatesByTeam(teamId).forEach(dates::add); // TODO - efficient ..?
		return ResponseEntity.ok().body(dates);
	}
	
	// get date by date
	@GetMapping
	public ResponseEntity<List<TrainingDate>> getTrainingDatesByDate(@PathVariable(name = "date") Date date) {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateService.getTrainingDatesByDate(date).forEach(dates::add); // TODO - efficient ..?
		return ResponseEntity.ok().body(dates);
	}
	
	// save new training date
	@PostMapping
	public ResponseEntity<Team> addTrainingDate(@Valid @RequestBody TrainingDate date) {
		trainingDateService.addTrainingDate(date);
		return ResponseEntity.ok().body(teamService.addTeam(team));
	}
	
	// delete training date by id
	@DeleteMapping("/{id}") // TODO - This @DeleteMapping okay?
	public void deleteTrainingDateById(@PathVariable int id) {
		trainingDateService.deleteTrainingDateById(id);
	}
}
