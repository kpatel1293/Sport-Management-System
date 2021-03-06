package edu.depaul.cdm.se.sportmanagementsystem.playerratingseason;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame.PlayerGameRatings;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;


@Controller
@RequestMapping("/api/v1/players/seasonRatings")
public class PlayerRatingController {
    @Autowired
    PlayerRatingService playerRatingService;

    @Autowired
    PlayerRatingRepository seasonRepo;
    
    @GetMapping
    public String showSeasonRatings(Model model) {
    	
    	model.addAttribute("ratings", seasonRepo.findAll());
    	
    	return "ratings/showSeasonRatings";
    }
    
    
    @RequestMapping(params = "addRating")
    public String addSeasonRating(Model model) {
    	model.addAttribute("seasonRating", new PlayerRating());
    	return "ratings/playerSeasonRatings";
    	
    	
    }
    
    
    // add rating
   // @RequestMapping(value="/gameRating", method=RequestMethod.POST)
    @PostMapping
    public String createRating(@ModelAttribute("seasonRatings")PlayerRating seasonRating, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
        	return "ratings/playerSeasonRatings";
        }
    	
    	seasonRepo.save(seasonRating);
        
    	return "redirect:/api/v1/players/seasonRatings";
    }
    
    
    
    
    /*
    // get all the ratings
    @GetMapping
    public List<PlayerRating> getAllPlayerRatings() {
        List<PlayerRating> playerRatings = new ArrayList<>();
        playerRatingService.getPlayerRatings().forEach(playerRating -> playerRatings.add(playerRating));

        return playerRatings;
    }

    // get a rating
    @GetMapping("/{id}")
    public ResponseEntity<PlayerRating> getRatingById(@PathVariable(name = "id") Long id) {
        PlayerRating playerRating = playerRatingService.getPlayerRating(id);

        return ResponseEntity.ok().body(playerRating);
    }
    
    // get all ratings by user  
    @GetMapping("/users/{user_id}")
    public List<PlayerRating> getRatingByUser(@PathVariable(name = "user_id") Long userID) {
        User user = userService.getUser(userID);
        
        return playerRatingService.getPlayerRatingsByUser(user);
    }
    
    // get a rating by player
    @GetMapping("/player/{id}")
    public List<PlayerRating> getRatingByPlayer(@PathVariable(name = "id") Long id) {
        return playerRatingService.getPlayerRatingsByPlayer(id);
    }
    
    
    // get all ratings for season
    @GetMapping("/season/{season}")
    public List<PlayerRating> getRatingByPlayer(@PathVariable(name = "season") int season) {
        return playerRatingService.getPlayerRatingsBySeason(season);
    }
    
    
    // get all ratings for season and player
    @GetMapping("/player/{id}/season/{season}")
    public List<PlayerRating> getRatingBySeasonAndPlayer(@PathVariable(name = "id") Long id, @PathVariable(name = "season") int season) {
        return playerRatingService.getPlayerRatingsBySeasonAndPlayer(id, season);
    } 
    
    // save rating
    @PostMapping("/user/{user_id}")
    public ResponseEntity<PlayerRating> saveRating(@PathVariable(name = "user_id") Long userId, @Valid @RequestBody PlayerRating playerRating) {
        User user = userService.getUser(userId);

        playerRating.setUser(user);
        playerRatingService.savePlayerRating(playerRating);

        return ResponseEntity.ok().body(playerRating);
    }
    
    
    // delete rating    
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRating(@PathVariable(value = "id") Long id) {
        PlayerRating playerRating = playerRatingService.getPlayerRating(id);

        playerRatingService.deleteRating(playerRating);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
*/
}