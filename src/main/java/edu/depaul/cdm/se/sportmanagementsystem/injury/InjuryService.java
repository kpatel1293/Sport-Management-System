package edu.depaul.cdm.se.sportmanagementsystem.injury;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjuryService {
    @Autowired 
    InjuryRepository injuryRepository;

    // get all
    public List<Injury> getAllInjuries() {
        List<Injury> injuries = new ArrayList<>();
        injuryRepository.findAll().forEach(injuries::add);

        return injuries;
    }

    // get all current injuries
    public List<Injury> getInjuries() {
        List<Injury> injuries = new ArrayList<>();
        injuryRepository.findAll().forEach(injury -> {
            if(injury.getIsInjured()) injuries.add(injury);
        });

        return injuries;
    }    
    
    // get a injury
    public Injury getAInjury(Long id) {
        return injuryRepository.findById(id).get();
    }

    // update
    public Injury updateInjury(Long id, Injury injury) {
        Injury updatedInjury = injuryRepository.findById(id).get();
        updatedInjury.setIsInjured(injury.getIsInjured());
        injuryRepository.save(updatedInjury);
        return updatedInjury;
    }
}