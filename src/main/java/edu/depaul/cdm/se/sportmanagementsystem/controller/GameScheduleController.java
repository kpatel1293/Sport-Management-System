package edu.depaul.cdm.se.sportmanagementsystem.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.model.GameSchedule;
import edu.depaul.cdm.se.sportmanagementsystem.service.GameScheduleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class GameScheduleController {
    @Autowired
    GameScheduleService gameScheduleService;

    // get all game schedules
    @GetMapping("/games")
    public List<GameSchedule> getAllGames() {
        return gameScheduleService.getAllGames();
    }

    // get a game schedule
    @GetMapping("/games/{id}")
    public ResponseEntity<GameSchedule> getGame(@PathVariable(name = "id") Long id) {
        GameSchedule gameSchedule = gameScheduleService.getGameSchedule(id);

        return ResponseEntity.ok().body(gameSchedule);
    }

    // get game schedules by team
    @GetMapping("/team/schedule/{team}")
    public ResponseEntity<List<GameSchedule>> getGameByTeam(@PathVariable(name = "team") String teamName) {
        List<GameSchedule> gameSchedules = new ArrayList<>();
        gameScheduleService.getGameScheduleByTeam(teamName).forEach(gameSchedule -> gameSchedules.add(gameSchedule));

        return ResponseEntity.ok().body(gameSchedules);
    }

    // get game schedules by season
    @GetMapping("/games/season/{year}")
    public ResponseEntity<List<GameSchedule>> getGamesBySeason(@PathVariable(name = "year") int year) {
        List<GameSchedule> gameSchedules = new ArrayList<>();
        gameScheduleService.getGameSchedulesBySeason(year).forEach(gameSchedule -> gameSchedules.add(gameSchedule));

        return ResponseEntity.ok().body(gameSchedules);
    }

    // save a game schedule
    @PostMapping(value="/games")
    public ResponseEntity<GameSchedule> createSchedule(@Valid @RequestBody GameSchedule gameSchedule) {
        gameScheduleService.saveGameSchedule(gameSchedule);
        
        return ResponseEntity.ok().body(gameSchedule);
    }
    
    
    // delete game schedule
    @DeleteMapping("/games/{id}")
    public Map<String, Boolean> deleteSchedule(@PathVariable(value = "id") Long id) {
        GameSchedule gameSchedule = gameScheduleService.getGameSchedule(id);

        gameScheduleService.deleteGameSchedule(gameSchedule);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
}