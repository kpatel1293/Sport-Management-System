package edu.depaul.cdm.se.sportmanagementsystem.playerratingseason;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.user.User;

@Service
public class PlayerRatingService {
    @Autowired
    PlayerRatingRepository playerRatingRepository;

    // get all the ratings
    public List<PlayerRating> getPlayerRatings() {
        List<PlayerRating> playerRatings = new ArrayList<>();
        playerRatingRepository.findAll().forEach(playerRating -> playerRatings.add(playerRating));

        return playerRatings;
    }

    // get a rating
    public PlayerRating getPlayerRating(Long id) {
        return playerRatingRepository.findById(id).get();
    }
    
    // get all ratings by user
    public List<PlayerRating> getPlayerRatingsByUser(User user) {
        List<PlayerRating> playerRatings = new ArrayList<>();

        playerRatingRepository.findAll().forEach(playerRating -> {
            if(playerRating.getUser().getId() == user.getId()) playerRatings.add(playerRating);
        });

        return playerRatings;
    }
    
    // get ratings by player
    public List<PlayerRating> getPlayerRatingsByPlayer(Long id) {
        List<PlayerRating> playerRatings = new ArrayList<>();

        playerRatingRepository.findAll().forEach(playerRating -> {
            if(playerRating.getPlayerId() == id) playerRatings.add(playerRating);
        });

        return playerRatings;
    }
    
    // get all ratings for season
    public List<PlayerRating> getPlayerRatingsBySeason(int season) {
        List<PlayerRating> playerRatings = new ArrayList<>();

        playerRatingRepository.findAll().forEach(playerRating -> {
            if(playerRating.getSeason() == season) playerRatings.add(playerRating);
        });

        return playerRatings;
    }
    
    // get all ratings for season and player
    public List<PlayerRating> getPlayerRatingsBySeasonAndPlayer(Long id, int season) {
        List<PlayerRating> playerRatings = new ArrayList<>();

        playerRatingRepository.findAll().forEach(playerRating -> {
            if(playerRating.getSeason() == season && playerRating.getPlayerId() == id) playerRatings.add(playerRating);
        });

        return playerRatings;
    }
    
    // save rating
    public PlayerRating savePlayerRating(PlayerRating playerRating) {
        Long count = playerRatingRepository.count() + 1;
        playerRating.setId(count);

        return playerRatingRepository.save(playerRating);
    }
    
    // delete rating
    public void deleteRating(PlayerRating playerRating) {
        playerRatingRepository.delete(playerRating);
    }
}