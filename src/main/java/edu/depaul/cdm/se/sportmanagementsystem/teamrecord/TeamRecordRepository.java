package edu.depaul.cdm.se.sportmanagementsystem.teamrecord;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRecordRepository extends MongoRepository<TeamRecord, Long> {
    
}