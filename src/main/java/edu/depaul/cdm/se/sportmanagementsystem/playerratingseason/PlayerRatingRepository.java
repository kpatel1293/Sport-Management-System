package edu.depaul.cdm.se.sportmanagementsystem.playerratingseason;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRatingRepository extends MongoRepository<PlayerRating, String> {
    
}