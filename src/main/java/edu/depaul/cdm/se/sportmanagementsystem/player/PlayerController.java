package edu.depaul.cdm.se.sportmanagementsystem.player;

import edu.depaul.cdm.se.sportmanagementsystem.gameschedule.GameSchedule;
import edu.depaul.cdm.se.sportmanagementsystem.managers.Managers;
import edu.depaul.cdm.se.sportmanagementsystem.managers.ManagersService;
import edu.depaul.cdm.se.sportmanagementsystem.teams.TeamService;
import edu.depaul.cdm.se.sportmanagementsystem.user.TypeOfUser;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.user.UserService;
import edu.depaul.cdm.se.sportmanagementsystem.user.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/v1/players")
public class PlayerController {
    @Autowired
    UserService userService;

    @Autowired
    PlayerServices playerService;

    @Autowired
    ManagersService managerService;

    @Autowired
    TeamService teamService;


    // get players
    @GetMapping("/all")
	public String getAllPlayers(Model model) {
    	model.addAttribute("players", playerService.getAllPlayers());
		return "list-players";
	}

    // get a player
    // @GetMapping("/{id}")
    // public ResponseEntity<Player> getPlayer(@PathVariable(name = "id") Long playerId) {
    //     Player player = playerService.getPlayer(playerId);

    //     return ResponseEntity.ok().body(player);
    // }

    // // get active players
    // @GetMapping("/active")
    // public ResponseEntity<List<Player>> getActivePlayers() {
    //     return ResponseEntity.ok().body(playerService.getActivePlayers());
    // }

    // // create player
    // @PostMapping("/managers/{manager_id}/users/{id}/{team}")
    // public ResponseEntity<Player> createPlayer(@PathVariable(name = "manager_id") Long managerId, @PathVariable(name = "id") Long userId, @PathVariable(name = "team") String team, @Valid @RequestBody Player player) {
    //     playerService.createPlayer(userId, team, player, managerId);

    //     return ResponseEntity.ok().body(player);
    // }

    // // update player
    
    // // delete player
    // @DeleteMapping("/{id}")
    // public Map<String, Boolean> deletePlayer(@PathVariable(value = "id") Long id) {
    //     Player player = playerService.getPlayer(id);

    //     playerService.deletePlayer(player);

    //     Map<String, Boolean> resp = new HashMap<>();
    //     resp.put("deleted", Boolean.TRUE);

    //     return resp;
    // }

    @RequestMapping(value ="player/{id}" , method = RequestMethod.POST)
    public String deleteUser(@PathVariable(value = "id") Long id, Model model ) {
        Player player = playerService.getPlayer(id);
        //User user = userService.getUser(id);
        playerService.deletePlayer(player);
//           if(user.getUserType() == TypeOfUser.PLAYER) {
//               Player player = playerService.getPlayerByUser(user);
//               player.setManager(null);
//                player.setTeam(null);
//               playerService.deletePlayer(player);
//           }

        model.addAttribute("players", playerService.getAllPlayers());



        return "redirect:/api/v1/players/all";
    }


    @GetMapping(value = "/redirect-add-or-edit/{edit}")
    public String redirectAddPlayer(@PathVariable(value = "edit") Long id, Model model) {
        Player p = new Player();
        if (id >=0) {
            p = playerService.getPlayer(id);
        }
        model.addAttribute("player", p);
        model.addAttribute("listPlayer", userService.findUserByType(TypeOfUser.PLAYER));
        model.addAttribute("listManager", managerService.getAllManagers());
        model.addAttribute("listTeam", teamService.getAllTeams());
        return "add-player";
    }

    @RequestMapping(value ="save" , method = RequestMethod.POST)
    public String addPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-player";
        }

        playerService.savePlayer(player);
        model.addAttribute("game_schedule", playerService.getAllPlayers());
        return "redirect:all";
    }
}
