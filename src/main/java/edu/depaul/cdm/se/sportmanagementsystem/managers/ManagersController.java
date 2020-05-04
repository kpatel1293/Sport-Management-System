package edu.depaul.cdm.se.sportmanagementsystem.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.player.*;

@RestController
@RequestMapping("/api/v1/managers")
public class ManagersController {
    @Autowired
    ManagersService managersService;

    // get all managers
    @GetMapping
    public ResponseEntity<List<Managers>> getAllManagers() {
        return ResponseEntity.ok().body(managersService.getAllManagers());
    }

    // get manager
    @GetMapping("/{id}")
    public ResponseEntity<Managers> getManager(@PathVariable(name = "id") Long id) {
        Managers managersR = managersService.getManager(id);

        return ResponseEntity.ok().body(managersR);
    }

    // get all team players for manager
    @GetMapping("/{id}/team")
    public ResponseEntity<List<Player>> getAllTeamMembersByManager(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(managersService.getTeamPlayers(id));
    }

    // create manager
    @PostMapping("/users/{id}/{team}")
    public ResponseEntity<Managers> createManager(@PathVariable(name = "id") Long userId, @PathVariable(name = "team") String team,@Valid @RequestBody Managers managers) {
        managersService.createManager(userId,team,managers);

        return ResponseEntity.ok().body(managers);
    }

    // delete manager
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteManager(@PathVariable(value = "id") Long id) {
        Managers manager = managersService.getManager(id);

        managersService.deleteManager(manager);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
}