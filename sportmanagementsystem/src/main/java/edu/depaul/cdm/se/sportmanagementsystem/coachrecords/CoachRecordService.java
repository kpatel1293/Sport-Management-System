package edu.depaul.cdm.se.sportmanagementsystem.coachrecords;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoachRecordService {
    @Autowired
    CoachRecordRepository coachRecordRepository;

    // get all the ratings
    public List<CoachRecord> getAllCoachRecords() {
        List<CoachRecord> coachRecords = new ArrayList<>();
        coachRecordRepository.findAll().forEach(coachRecords::add);
		return coachRecords;
    }

    public CoachRecord getCoachRecordById(Long id) {
        return coachRecordRepository.findById(id).get();
    }
    
    // get coach records by name
    public List<CoachRecord> getCoachRecordsByName(String name) {
		List<CoachRecord> coachRecords = new ArrayList<>();
		coachRecordRepository.findAll().forEach(coachRecord -> {
			if (coachRecord.getName().equals(name)) // TODO: redundant, broken..? verify this works ..?
				coachRecords.add(coachRecord);
		});
		return coachRecords;
	}

	public CoachRecord addCoachRecord(CoachRecord coach) {
		return coachRecordRepository.save(coach);	
	}
	
	// TODO - add update method without removal?
	
	public void deleteCoachRecordById(Long id) {
		coachRecordRepository.deleteById(id);
	}
}