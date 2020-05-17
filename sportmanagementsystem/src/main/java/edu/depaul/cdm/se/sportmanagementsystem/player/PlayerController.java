package edu.depaul.cdm.se.sportmanagementsystem.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/players")
public class PlayerController {
    @Autowired
    PlayerServices playerService;

    // get players
//    @GetMapping
//    public ResponseEntity<List<Player>> getAllPlayers() {
//       return ResponseEntity.ok().body(playerService.getAllPlayers());
//    }
    @GetMapping("/all")
	public String getAllPlayers(Model model) {
    	model.addAttribute("players", playerService.getAllPlayers());
			return "list-players";
	}

    // get a player
    //@RequestBody
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable(name = "id") Long playerId) {
        Player player = playerService.getPlayer(playerId);

        return ResponseEntity.ok().body(player);
    }

    // get active players
    @GetMapping("/active")
    public ResponseEntity<List<Player>> getActivePlayers() {
        return ResponseEntity.ok().body(playerService.getActivePlayers());
    }

    // create player
    @PostMapping("/managers/{manager_id}/users/{id}/{team}")
    public ResponseEntity<Player> createPlayer(@PathVariable(name = "manager_id") Long managerId, @PathVariable(name = "id") Long userId, @PathVariable(name = "team") String team, @Valid @RequestBody Player player) {
        playerService.createPlayer(userId, team, player, managerId);

        return ResponseEntity.ok().body(player);
    }

    // update player
    
    // delete player
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePlayer(@PathVariable(value = "id") Long id) {
        Player player = playerService.getPlayer(id);

        playerService.deletePlayer(player);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
}