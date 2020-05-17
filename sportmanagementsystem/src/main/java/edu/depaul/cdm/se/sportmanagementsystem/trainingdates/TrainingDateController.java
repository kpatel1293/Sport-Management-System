package edu.depaul.cdm.se.sportmanagementsystem.trainingdates;

import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("/api/v1/trainingdates")
public class TrainingDateController {
	
	@Autowired 
	private TrainingDateService trainingDateService;
	
	// get all dates
	@GetMapping // TODO - @GetMapping("/trainingdates") ??
	public List<TrainingDate> getAllTrainingDates(){
		return trainingDateService.getAllTrainingDates();
	}
	
	// get date by id
	@GetMapping("/{id}")
	public ResponseEntity<TrainingDate> getTrainingDateById(@PathVariable(name = "id") int id) {
		TrainingDate date = trainingDateService.getTrainingDateById(id);
		return ResponseEntity.ok().body(date);
	}
	
	// get date by team id
	@GetMapping("/{teamId}")
	public ResponseEntity<List<TrainingDate>> getTrainingDatesByTeam(@PathVariable(name = "teamId") int teamId) {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateService.getTrainingDatesByTeamId(teamId).forEach(dates::add); // TODO - efficient ..?
		return ResponseEntity.ok().body(dates);
	}
	
	// get date by date
	@GetMapping("/{date}")
	public ResponseEntity<List<TrainingDate>> getTrainingDatesByDate(@PathVariable(name = "date") Date date) {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateService.getTrainingDatesByDate(date).forEach(dates::add); // TODO - efficient ..?
		return ResponseEntity.ok().body(dates);
	}
	
	// save new training date
	@PostMapping
	public ResponseEntity<TrainingDate> addTrainingDate(@Valid @RequestBody TrainingDate date) {
		TrainingDate trainingDate = trainingDateService.addTrainingDate(date);
		return ResponseEntity.ok().body(trainingDate);
	}
	
	// delete training date by id
	@DeleteMapping("/{id}") // TODO - This @DeleteMapping okay?
	public void deleteTrainingDateById(@PathVariable int id) {
		trainingDateService.deleteTrainingDateById(id);
	}
}
