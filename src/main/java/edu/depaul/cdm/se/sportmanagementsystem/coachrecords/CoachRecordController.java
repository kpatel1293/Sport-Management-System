package edu.depaul.cdm.se.sportmanagementsystem.coachrecords;

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
@RequestMapping("/api/v1/teams/coachrecords") // TODO: Good ..?
public class CoachRecordController {
    @Autowired
    CoachRecordService coachRecordService;

    @GetMapping
    public List<CoachRecord> getAllCoachRecords() {
        List<CoachRecord> coachRecords = new ArrayList<>();
        coachRecordService.getAllCoachRecords().forEach(coachRecords::add); // TODO: direct pass through/RVO without copying?
        return coachRecords;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachRecord> getCoachRecordById(@PathVariable(name = "id") Long id) {
    	CoachRecord coachRecord = coachRecordService.getCoachRecordById(id);
		return ResponseEntity.ok().body(coachRecord);
	}
    
	// save new injury
	@PostMapping
	public ResponseEntity<CoachRecord> addCoachRecord(@Valid @RequestBody CoachRecord coachRecord) {
		CoachRecord c = coachRecordService.addCoachRecord(coachRecord);
		return ResponseEntity.ok().body(c);
	}
	
	// delete injury by id
	@DeleteMapping("/{id}") // TODO - This @DeleteMapping okay?
	public void deleteCoachRecordById(@PathVariable Long id) {
		coachRecordService.deleteCoachRecordById(id);
	}

}