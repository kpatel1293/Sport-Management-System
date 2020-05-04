package edu.depaul.cdm.se.sportmanagementsystem.injury;

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

import edu.depaul.cdm.se.sportmanagementsystem.player.Player;
import lombok.Data;

@Entity
@Data
@Table(name = "injured_players")
public class Injury implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "injured_id")
    private Long id;

    // player id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private Player player;
    
    // injured
    @Column(name = "isInjured")
    private Boolean isInjured;
}