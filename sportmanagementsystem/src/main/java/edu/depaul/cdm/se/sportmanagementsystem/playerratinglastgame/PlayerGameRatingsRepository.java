package edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerGameRatingsRepository extends MongoRepository<PlayerGameRatings, Long> {

}
