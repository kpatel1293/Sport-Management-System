package edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class PlayerGameRatingsController {
    @Autowired
    PlayerGameRatingsService playerGameRatingsService;

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

    // add rating
    @PostMapping
    public PlayerGameRatings createRating(PlayerGameRatings rating) {
        return playerGameRatingsService.createRating(rating);
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
}