package edu.depaul.cdm.se.sportmanagementsystem.injury;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/injury")
public class InjuryController {
    @Autowired
    InjuryService injuryService;

    // get all
    @GetMapping
    public ResponseEntity<List<Injury>> getAllInjuries() {
        return ResponseEntity.ok().body(injuryService.getAllInjuries());
    }

    // get all current injuries
    @GetMapping("/current")
    public ResponseEntity<List<Injury>> getInjuries() {
        return ResponseEntity.ok().body(injuryService.getInjuries());
    }    
    
    // get a injury
    @GetMapping("/{id}")
    public ResponseEntity<Injury> getAInjury(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(injuryService.getAInjury(id));
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Injury> updateInjury(@PathVariable(name = "id") Long id,@Valid @RequestBody Injury injury) {
        Injury i = injuryService.updateInjury(id, injury);

        return ResponseEntity.ok().body(i);
    }
}