package edu.depaul.cdm.se.sportmanagementsystem.player;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.managers.Managers;
import edu.depaul.cdm.se.sportmanagementsystem.managers.ManagersRepository;
import edu.depaul.cdm.se.sportmanagementsystem.teams.TeamRepository;
import edu.depaul.cdm.se.sportmanagementsystem.user.TypeOfUser;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.user.UserRepository;

@Service
@Transactional
public class PlayerServices {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ManagersRepository managersRepository;

    // get players
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);

        return players;
    }
    
    // get a player
    public Player getPlayer(Long playerId) {
        return playerRepository.findById(playerId).get();
    }

    // get active players
    public List<Player> getActivePlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(player -> {
            if(player.getIsActive()) players.add(player);
        });

        return players;
    }

    // create player
    public Player createPlayer(Long userId, String team, Player player, Long managerId) {
        User user = userRepository.findById(userId).get();
        user.setUserType(TypeOfUser.PLAYER);
        userRepository.save(user);
        player.setUser(user);
        player.setTeam(teamRepository.findById(team).get());

        Managers manager = managersRepository.findById(managerId).get();
        player.setManager(manager);

        return playerRepository.save(player);
    }

    public Player getPlayerByUser(User user) {
        return playerRepository.findByUser(user);
    }

    public List<Player> getPlayerByManager(Managers manager) {
        List<Player> players = new ArrayList<>();
        playerRepository.findByManager(manager).forEach(players::add);

        return players;
    }

    // update player
    
    // delete player
    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }
}
