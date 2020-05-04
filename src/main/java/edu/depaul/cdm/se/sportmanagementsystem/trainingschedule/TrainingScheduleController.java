package edu.depaul.cdm.se.sportmanagementsystem.trainingschedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class TrainingScheduleController {
    @Autowired
    TrainingScheduleService TrainingScheduleService;

    // get all game schedules
    @GetMapping("/TrainingS")
    public List<TrainingSchedule> getAllTrainingS() {
        return TrainingScheduleService.getAllSchedules();
    }

    // get a game schedule
    @GetMapping("/TrainingS/{id}")
    public ResponseEntity<TrainingSchedule> getGame(@PathVariable(name = "id") Long id) {
        TrainingSchedule TrainingSchedule = TrainingScheduleService.getTrainingSchedule(id);

        return ResponseEntity.ok().body(TrainingSchedule);
    }

    // get game schedules by team
    @GetMapping("/TrainingS/team/{team}")
    public ResponseEntity<List<TrainingSchedule>> getGameByTeam(@PathVariable(name = "team") String teamName) {
        List<TrainingSchedule> TrainingSchedules = new ArrayList<>();
        TrainingScheduleService.getTrainingSchedulesByTeam(teamName).forEach(TrainingSchedule -> TrainingSchedules.add(TrainingSchedule));

        return ResponseEntity.ok().body(TrainingSchedules);
    }

    // get game schedules by season
    @GetMapping("/TrainingS/season/{year}")
    public ResponseEntity<List<TrainingSchedule>> getTrainingSBySeason(@PathVariable(name = "year") int year) {
        List<TrainingSchedule> TrainingSchedules = new ArrayList<>();
        TrainingScheduleService.getTrainingSchedule(year).forEach(TrainingSchedule -> TrainingSchedules.add(TrainingSchedule));

        return ResponseEntity.ok().body(TrainingSchedules);
    }

    // save a game schedule
    @PostMapping(value="/TrainingS")
    public ResponseEntity<TrainingSchedule> createSchedule(@Valid @RequestBody TrainingSchedule TrainingSchedule) {
        TrainingScheduleService.saveSchedule(TrainingSchedule);
        
        return ResponseEntity.ok().body(TrainingSchedule);
    }
    
    
    // delete game schedule
    @DeleteMapping("/TrainingS/{id}")
    public Map<String, Boolean> deleteSchedule(@PathVariable(value = "id") Long id) {
        TrainingSchedule TrainingSchedule = TrainingScheduleService.getTrainingSchedule(id);

        TrainingScheduleService.deleteSchedule(TrainingSchedule);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
}