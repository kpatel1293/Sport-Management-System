package edu.depaul.cdm.se.sportmanagementsystem.teamrecord;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.depaul.cdm.se.sportmanagementsystem.teams.TeamRepository;

@Service
public class TeamRecordService {
    @Autowired
    TeamRecordRepository teamRecordRepository;

    @Autowired
    TeamRepository teamRepository;

    // get all the records
    public List<TeamRecord> getTeamRecords() {
        List<TeamRecord> records = new ArrayList<>();
        teamRecordRepository.findAll().forEach(records::add);

        return records;
    }

    // get a record
    public TeamRecord getTeamRecord(Long id) {
        return teamRecordRepository.findById(id).get();
    }
    
    // update record
    public TeamRecord updatedTeamRecord(Long id, TeamRecord teamRecord) {
        teamRecord.setId(id);
        String teamId = teamRecordRepository.findById(id).get().getTeam().getTeamName();
        teamRecord.setTeam(teamRepository.findById(teamId).get());

        return teamRecordRepository.save(teamRecord);
    }
}