package edu.depaul.cdm.se.sportmanagementsystem.managers;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.depaul.cdm.se.sportmanagementsystem.teams.Team;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import lombok.Data;

@Entity
@Data
@Table(name = "managers")
public class Managers implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    // user id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    // team
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_name")
    private Team team;

    // player list
    // private List<PlayerR> listPlayers;
}
