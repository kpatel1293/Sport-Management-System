package edu.depaul.cdm.se.sportmanagementsystem.injuries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjuryService {
	@Autowired
	private InjuryRepository injuryRepository;
	
	public List<Injury> getAllInjuries() {
		List<Injury> injuries = new ArrayList<>();
		injuryRepository.findAll().forEach(injuries::add);
		return injuries;
	}
	
	public Injury getInjuryById(int id) {
        return injuryRepository.findById(id).get();
    }

	public List<Injury> getInjuryByPlayerId(int playerId) {
		List<Injury> injuries = new ArrayList<>();
		injuryRepository.findAll().forEach(injury -> {
			if (injury.getPlayerId() == playerId) // TODO: does this seem redundant or broken ...?
				injuries.add(injury);
		});
		return injuries;
	}
	
	public Injury addInjury(Injury injury) {
		return injuryRepository.save(injury);	
	}
	
	// TODO - add update method without removal?
	
	public void deleteInjuryById(int id) {
		injuryRepository.deleteById(id);
	}
}
