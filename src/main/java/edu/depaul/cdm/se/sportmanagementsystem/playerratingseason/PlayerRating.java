package edu.depaul.cdm.se.sportmanagementsystem.playerratingseason;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame.PlayerGameRatings;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "player_ratings")
public class PlayerRating implements Serializable {
    private static final long serialVersionUID = 8L;
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private String id;

    // rating
    @Column(name = "rating")
    private String rating;
    
    // player
    @Column(name = "player")
    private Long playerId;
    
    // season
    @Column(name = "season")
    private String season;

    // user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    

	@Column(name = "message")
	private String message;
}