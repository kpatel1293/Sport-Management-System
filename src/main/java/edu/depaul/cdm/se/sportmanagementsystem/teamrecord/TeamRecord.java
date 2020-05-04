package edu.depaul.cdm.se.sportmanagementsystem.teamrecord;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se.sportmanagementsystem.teams.Team;
import lombok.Data;

@Data
@Document(collection = "team_record")
public class TeamRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "record_id")
    private Long id;

    // amount of won games
    @Column(name = "won_games")
    private int wonGames;
    // amount of lost games
    @Column(name = "lost_games")
    private int lostGames;

    // team
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;
}