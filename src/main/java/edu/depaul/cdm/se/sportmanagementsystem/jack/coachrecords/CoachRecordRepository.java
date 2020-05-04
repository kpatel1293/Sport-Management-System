package edu.depaul.cdm.se.sportmanagementsystem.jack.coachrecords;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRecordRepository extends MongoRepository<CoachRecord, Long> {
    
}