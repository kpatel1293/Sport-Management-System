package edu.depaul.cdm.se.sportmanagementsystem.ratingteam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.user.UserService;

@RestController
@RequestMapping("/api/v1/teams/ratings")
public class RatingController {
    @Autowired
    RatingService ratingService;
    
    @Autowired
    UserService userService;

    // get all ratings
    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    // get rating
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable(name = "id") Long ratingId) {
        Rating rating = ratingService.getRating(ratingId);

        return ResponseEntity.ok().body(rating);
    }

    // get ratings by team
    @GetMapping("/team/{team}")
    public ResponseEntity<List<Rating>> getRatingByTeam(@PathVariable(name = "team") String team) {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingService.getRatingByTeam(team).forEach(rating -> ratings.add(rating));

        return ResponseEntity.ok().body(ratings);
    }

    // get ratings by user
    @GetMapping("/users/{user_id}")
    public List<Rating> getRatingByUser(@PathVariable(name = "user_id") Long userID) {
        User user = userService.getUser(userID);
        
        return ratingService.getRatingByUser(user);
    }

    // save rating
    @PostMapping("/users/{user_id}")
    public ResponseEntity<Rating> saveRating(@PathVariable(name = "user_id") Long userId, @Valid @RequestBody Rating rating) {
        User user = userService.getUser(userId);

        rating.setUser(user);
        ratingService.saveRating(rating);

        return ResponseEntity.ok().body(rating);
    }

    // delete rating
    @DeleteMapping("/{rating_id}")
    public Map<String, Boolean> deleteRating(@PathVariable(value = "rating_id") Long id) {
        Rating rating = ratingService.getRating(id);

        ratingService.deleteRating(rating);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
}