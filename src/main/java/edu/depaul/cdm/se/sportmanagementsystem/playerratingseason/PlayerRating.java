package edu.depaul.cdm.se.sportmanagementsystem.playerratingseason;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import lombok.Data;

@Data
@Document(collection = "player_ratings")
public class PlayerRating implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "rating_id")
    private Long id;

    // rating
    @Column(name = "rating")
    private int rating;
    
    // player
    @Column(name = "player")
    private Long playerId;
    
    // season
    @Column(name = "season")
    private int season;

    // user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}