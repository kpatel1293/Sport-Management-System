package edu.depaul.cdm.se.sportmanagementsystem.gameschedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameScheduleService {
    @Autowired
    GameScheduleRepository gameScheduleRepository;

    // get all game schedules
    public List<GameSchedule> getAllGames() {
        return gameScheduleRepository.findAll();
    }

    // get a game schedule
    public GameSchedule getGameSchedule(Long gameId) {
        return gameScheduleRepository.findById(gameId).get();
    }

    // get game schedules by team
    public List<GameSchedule> getGameScheduleByTeam(String team) {
        List<GameSchedule> gameSchedules = new ArrayList<GameSchedule>();
        gameScheduleRepository.findAll().forEach(gameSchedule -> {
            if(gameSchedule.getAwayTeam().equals(team) || gameSchedule.getHomeTeam().equals(team)) gameSchedules.add(gameSchedule);
        });

        return gameSchedules;
    }

    // get game schedules by season
    public List<GameSchedule> getGameSchedulesBySeason(int year) {
        List<GameSchedule> gameSchedules = new ArrayList<GameSchedule>();
        gameScheduleRepository.findAll().forEach(gameSchedule -> {
            if(gameSchedule.getSeason() == year) gameSchedules.add(gameSchedule);
        });

        return gameSchedules;
    }

    // save a game schedule
    public GameSchedule saveGameSchedule(GameSchedule gameSchedule) {
        return gameScheduleRepository.save(gameSchedule);
    }

    // delete game schedule
    public void deleteGameSchedule(GameSchedule gameSchedule) {
        gameScheduleRepository.delete(gameSchedule);
    }
}