package edu.depaul.cdm.se.sportmanagementsystem.trainingschedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingScheduleService {
    @Autowired
    TrainingScheduleRepository trainingScheduleRepository;

    // get all training schedules
    public List<TrainingSchedule> getAllSchedules() {
        List<TrainingSchedule> trainingSchedules = new ArrayList<TrainingSchedule>();
        trainingScheduleRepository.findAll().forEach(trainingSchedules::add);

        return trainingSchedules;
    }

    // get a training schedule
    public TrainingSchedule getTrainingSchedule(Long id) {
        return trainingScheduleRepository.findById(id).get();
    }

    // get training schedules by team
    public List<TrainingSchedule> getTrainingSchedulesByTeam(String team) {
        List<TrainingSchedule> trainingSchedules = new ArrayList<TrainingSchedule>();
        trainingScheduleRepository.findAll().forEach(trainingSchedule -> {
            if(trainingSchedule.getTeam().equals(team)) trainingSchedules.add(trainingSchedule);
        });

        return trainingSchedules;
    }

    // get training schedules by season
    public List<TrainingSchedule> getTrainingSchedule(int year) {
        List<TrainingSchedule> trainingSchedules = new ArrayList<TrainingSchedule>();
        trainingScheduleRepository.findAll().forEach(trainingSchedule -> {
            if(trainingSchedule.getSeason() == year) trainingSchedules.add(trainingSchedule);
        });

        return trainingSchedules;
    }

    // save a training schedule
    public TrainingSchedule saveSchedule(TrainingSchedule trainingSchedule) {
        return trainingScheduleRepository.save(trainingSchedule);
    }

    // delete training schedule
    public void deleteSchedule(TrainingSchedule trainingSchedule) {
        trainingScheduleRepository.delete(trainingSchedule);
    }
}