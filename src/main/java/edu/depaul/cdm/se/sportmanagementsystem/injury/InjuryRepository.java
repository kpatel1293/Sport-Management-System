package edu.depaul.cdm.se.sportmanagementsystem.injury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InjuryRepository extends JpaRepository<Injury, Long> {

}