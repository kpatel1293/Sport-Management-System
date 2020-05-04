package edu.depaul.cdm.se.sportmanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.se.sportmanagementsystem.model.PlayerRating;

@Repository
public interface PlayerRatingRepository extends MongoRepository<PlayerRating, Long> {
    
}