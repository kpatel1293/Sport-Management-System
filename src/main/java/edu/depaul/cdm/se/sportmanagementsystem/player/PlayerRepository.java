package edu.depaul.cdm.se.sportmanagementsystem.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.se.sportmanagementsystem.managers.Managers;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByUser(User user);
    List<Player> findByManager(Managers managers);
}