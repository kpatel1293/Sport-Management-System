package edu.depaul.cdm.se.sportmanagementsystem.jack.coachrecords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import edu.depaul.cdm.se.sportmanagementsystem.krishna.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.krishna.user.UserService;

@RestController
@RequestMapping("/api/v1/teams/coachrecords") // TODO: Good ..?
public class CoachRecordController {
    @Autowired
    CoachRecordService coachRecordService;

    @GetMapping
    public List<CoachRecord> getAllCoachRecords() {
        List<CoachRecord> coachRecords = new ArrayList<>();
        coachRecordService.getPlayerRatings().forEach(coachRecords::add); // TODO: direct pass through/RVO without copying?
        return coachRecords;
    }

    @GetMapping
    public ResponseEntity<Injury> getCoachRecordById(@PathVariable(name = "id") int id) {
    	CoachRecord coachRecord = coachRecordService.getCoachRecordById(id);
		return ResponseEntity.ok().body(coachRecord);
	}
    
	// save new injury
	@PostMapping
	public ResponseEntity<Team> addCoachRecord(@Valid @RequestBody CoachRecord coachRecord) {
		coachRecordService.addCoachRecord(coachRecord);
		return ResponseEntity.ok().body(coachRecordService.addCoachRecord(injury));
	}
	
	// delete injury by id
	@DeleteMapping("/{id}") // TODO - This @DeleteMapping okay?
	public void deleteCoachRecordById(@PathVariable int id) {
		coachRecordService.deleteCoachRecordById(id);
	}

}