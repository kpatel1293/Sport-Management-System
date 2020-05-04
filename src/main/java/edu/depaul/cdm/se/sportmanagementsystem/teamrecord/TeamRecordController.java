package edu.depaul.cdm.se.sportmanagementsystem.teamrecord;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/team/records")
public class TeamRecordController {
    @Autowired
    TeamRecordService teamRecordService;

    // get all the records
    @GetMapping
    public ResponseEntity<List<TeamRecord>> getRecords() {
        return ResponseEntity.ok().body(teamRecordService.getTeamRecords());
    }

    // get a record
    @GetMapping("/{id}")
    public ResponseEntity<TeamRecord> getManagerRecord(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(teamRecordService.getTeamRecord(id));
    }
    
    // update record
    @PutMapping("/{id}")
    public ResponseEntity<TeamRecord> updateManagerRecord(@PathVariable(name = "id") Long id, @Valid @RequestBody TeamRecord teamRecord) {
        TeamRecord mr = teamRecordService.updatedTeamRecord(id, teamRecord);

        return ResponseEntity.ok().body(mr);
    }
}