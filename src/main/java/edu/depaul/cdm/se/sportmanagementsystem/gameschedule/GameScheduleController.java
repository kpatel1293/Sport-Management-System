package edu.depaul.cdm.se.sportmanagementsystem.gameschedule;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1")
public class GameScheduleController {
    @Autowired
    GameScheduleService gameScheduleService;

    // get all game schedules
//    @GetMapping("/games")
//    public List<GameSchedule> getAllGames() {
//        return gameScheduleService.getAllGames();
//    }
    
    
    @GetMapping("/all")
 	public String getAllGames(Model model) {
     	model.addAttribute("game_schedule", gameScheduleService.getAllGames());
 			return "schedule-list";
 	}

    @GetMapping("/manager-landing")
    public String getMenuManger(Model model) {
        //model.addAttribute("game_schedule", gameScheduleService.getAllGames());
        return "manager-landing";
    }

    // get a game schedule
    @GetMapping("/games/{id}")
    public ResponseEntity<GameSchedule> getGame(@PathVariable(name = "id") Long id) {
        GameSchedule gameSchedule = gameScheduleService.getGameSchedule(id);

        return ResponseEntity.ok().body(gameSchedule);
    }

    // get game schedules by team
    @GetMapping("/games/team/{team}")
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
//    @PostMapping(value="/games")
//    public ResponseEntity<GameSchedule> createSchedule(@Valid @RequestBody GameSchedule gameSchedule) {
//        gameScheduleService.saveGameSchedule(gameSchedule);
//        
//        return ResponseEntity.ok().body(gameSchedule);
//    }
    
    @GetMapping(value = "/redirect-add-or-edit/{edit}")
    public String redirectAddSchedule(@PathVariable(value = "edit") Long id, Model model) {
        GameSchedule p = new GameSchedule();
        if (id >=0) {
            p = gameScheduleService.getGameSchedule(id);
        }
        model.addAttribute("schedule", p);
    	return "schedule-input";
    }

//    @PostMapping(value = "/save-schedule")
//    public String createSchedule(@ModelAttribute  GameSchedule schedule, Model model) {
// 		//gameScheduleService.saveGameSchedule(schedule);
//    	
//      return "schedule-list";
//    }
    // @PostMapping("/save-schedule")
   @RequestMapping(value="/save-schedule", method=RequestMethod.POST)
    public String createSchedule(@Valid @ModelAttribute("schedule") GameSchedule schedule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "schedule-input";
        }
         
        gameScheduleService.saveGameSchedule(schedule);
        model.addAttribute("game_schedule", gameScheduleService.getAllGames());
        return "redirect:all";
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

    @RequestMapping(value="game/{id}", method=RequestMethod.POST)
    public String deleteSchedule(@PathVariable(value = "id")  Long id, Model model) {
        GameSchedule gameSchedule = gameScheduleService.getGameSchedule(id);
        if( gameSchedule != null) {
            gameScheduleService.deleteGameSchedule(gameSchedule);
        }
        model.addAttribute("game_schedule", gameScheduleService.getAllGames());
        return "redirect:/api/v1/all";
    }
}