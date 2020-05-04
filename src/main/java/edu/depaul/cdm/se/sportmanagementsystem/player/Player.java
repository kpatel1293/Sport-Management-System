package edu.depaul.cdm.se.sportmanagementsystem.player;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.depaul.cdm.se.sportmanagementsystem.managers.Managers;
import edu.depaul.cdm.se.sportmanagementsystem.teams.Team;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import lombok.Data;

@Entity
@Data
@Table(name = "players")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int id;
    
    // user id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    // team
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;
    
    // active or inactive
    @Column(name = "active_player")
    private Boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "manager_id")
    public Managers manager;
}
