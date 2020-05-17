package edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameRatingsService {
    @Autowired
    PlayerGameRatingsRepository playerGameRatingsRepository;

    // get all rating
    public List<PlayerGameRatings> getAllPlayerGameRatings() {
        List<PlayerGameRatings> playerGameRatings = new ArrayList<>();
        playerGameRatingsRepository.findAll().forEach(playerGameRatings::add);
        return playerGameRatings;
    }

    // get rating
    public PlayerGameRatings getRating(Long id) {
        return playerGameRatingsRepository.findById(id).get();
    }

    // add rating
    public PlayerGameRatings createRating(PlayerGameRatings rating) {
        Long count = playerGameRatingsRepository.count() + 1;
        rating.setRatingId(count);

        return playerGameRatingsRepository.save(rating);
    }

    // delete rating
    public void deleteRating(PlayerGameRatings playerGameRatings) {
        playerGameRatingsRepository.delete(playerGameRatings);
    }
}