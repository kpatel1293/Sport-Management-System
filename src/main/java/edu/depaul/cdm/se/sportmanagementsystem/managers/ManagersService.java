package edu.depaul.cdm.se.sportmanagementsystem.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.player.Player;
import edu.depaul.cdm.se.sportmanagementsystem.player.PlayerRepository;
import edu.depaul.cdm.se.sportmanagementsystem.teams.TeamRepository;
import edu.depaul.cdm.se.sportmanagementsystem.user.TypeOfUser;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.user.UserRepository;

@Service
public class ManagersService {
    @Autowired
    ManagersRepository managersepository;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerepository;

    // get all managers
    public List<Managers> getAllManagers() {
        List<Managers> managers = new ArrayList<Managers>();
        managersepository.findAll().forEach(managers::add);

        return managers;
    }
 
    // get manager
    public Managers getManager(Long id) {
        return managersepository.findById(id).get();
    } 

    // get all team memebers
    public List<Player> getTeamPlayers(Long managerID) {
        List<Player> players = new ArrayList<>();
        playerepository.findAll().forEach(player -> {
            if(player.getManager().getId().equals(managerID)) players.add(player);
        });

        return players;
    }

    // create manager
    public Managers createManager(Long userId, String team, Managers manager) {
        User user = userRepository.findById(userId).get();
        user.setUserType(TypeOfUser.MANAGER);
        userRepository.save(user);
        manager.setUser(user);
        manager.setTeam(teamRepository.findById(team).get());

        return managersepository.save(manager);
    }

    // delete manager
    public void deleteManager(Managers manager) {
        managersepository.delete(manager);
    }
}