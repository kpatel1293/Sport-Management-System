package edu.depaul.cdm.se.sportmanagementsystem.trainingdates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingDateService {
	@Autowired
	private TrainingDateRepository trainingDateRepository;
	
	// get every TrainingDate in TrainingDates
	public List<TrainingDate> getAllTrainingDates() {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateRepository.findAll().forEach(dates::add);
		return dates;
	}
	
	// get a certain TrainingDate
	public TrainingDate getTrainingDateById(int id) {
        return trainingDateRepository.findById(id).get();
    }
	
	// get every TrainingDate for a certain Team, code adapted from Krishna.GameScheduleService
	// TODO - allow searching by team name? would require team name stored in TrainingDates
	public List<TrainingDate> getTrainingDatesByTeamId(int teamId) {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateRepository.findAll().forEach(trainingDate -> {
			if (trainingDate.getTeamId() == teamId) // TODO: is this not redundant?
				dates.add(trainingDate);
		});
		return dates;
	}
	
	// get every TrainingDate at a particular day. TODO - time?
	public List<TrainingDate> getTrainingDatesByDate(Date date) {
		List<TrainingDate> dates = new ArrayList<>();
		trainingDateRepository.findAll().forEach(trainingDate -> {
			if (trainingDate.getDate().equals(date))
				dates.add(trainingDate);
		});
		return dates;
	}
	
	// add TrainingDate to TrainingDates table
	public TrainingDate addTrainingDate(TrainingDate date) {
		return trainingDateRepository.save(date);	
	}
	
	// TODO - add update method without removal?
	
	public void deleteTrainingDateById(int id) {
		trainingDateRepository.deleteById(id);
	}
}
