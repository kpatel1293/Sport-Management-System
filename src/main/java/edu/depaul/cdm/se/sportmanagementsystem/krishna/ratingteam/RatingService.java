package edu.depaul.cdm.se.sportmanagementsystem.krishna.ratingteam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.krishna.user.User;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    // get all ratings
    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findAll().forEach(rating -> ratings.add(rating));

        return ratings;
    }

    // get rating by Id
    public Rating getRating(Long id) {
        return ratingRepository.findById(id).get();
    }

    // get ratings by team
    public List<Rating> getRatingByTeam(String team) {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findAll().forEach(rating -> {
            if(rating.getTeam().equals(team)) ratings.add(rating);
        });

        return ratings;
    }

    // get ratings by user
    public List<Rating> getRatingByUser(User user) {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findAll().forEach(rating -> {
            if(rating.getUser().getId() == user.getId()) ratings.add(rating);
        });

        return ratings;
    }

    // save rating
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // delete rating
    public void deleteRating(Rating rating) {
        ratingRepository.delete(rating);
    }
}