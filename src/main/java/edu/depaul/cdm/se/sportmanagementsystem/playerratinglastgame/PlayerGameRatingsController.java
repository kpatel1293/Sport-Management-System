package edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/api/v1/rating")
public class PlayerGameRatingsController {
    @Autowired
    PlayerGameRatingsService playerGameRatingsService;
    @Autowired
    PlayerGameRatingsRepository gameRepo;
    
    
    
    
    @RequestMapping(params = "addRating")
    public String addRating(Model model) {
    	model.addAttribute("gameRating", new PlayerGameRatings());
    	return "ratings/playerGameRatings";
    	
    	
    }
    
    
    
    // add rating
   // @RequestMapping(value="/gameRating", method=RequestMethod.POST)
    @PostMapping
    public String createRating(@ModelAttribute("gameRating")PlayerGameRatings gameRating, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
        	return "ratings/playerGameRatings";
        }
    	
    	gameRepo.save(gameRating);
        
    	return "redirect:/gameRating";
    }
    
    
    /*
    

    // get all rating
    @GetMapping
    public ResponseEntity<List<PlayerGameRatings>> getAllPlayerGameRatings() {
        return ResponseEntity.ok().body(playerGameRatingsService.getAllPlayerGameRatings());
    }
    
    // get rating
    @GetMapping("/{id}")
    public PlayerGameRatings getRating(@PathVariable("id") Long id) {
        return playerGameRatingsService.getRating(id);
    }
    
    @GetMapping("/api/v1/{id}/game")
    public String getrating(Model model, @PathVariable(name = "id") Long id) {
    	model.addAttribute("playerGameRatings", playerGameRatingsService.getRating(id));
    	return "ratings/playerGameRatings";
    	
    }
    
  



    // delete rating
    @DeleteMapping("{/id}")
    public Map<String, Boolean> deleteRating(@PathVariable("id") Long id, PlayerGameRatings playerGameRatings) {
        PlayerGameRatings pcr = playerGameRatingsService.getRating(id);
    
        playerGameRatingsService.deleteRating(pcr);
    
        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);
    
        return resp;
    }
    
    
    */
    
    
    
}