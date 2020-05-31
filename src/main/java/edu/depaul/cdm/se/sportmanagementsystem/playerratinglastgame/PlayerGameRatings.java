package edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document
public class PlayerGameRatings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Id
	@Column(name = "player_rating_id")
	private Long ratingId;

	@Column(name = "rating")
	private String rating1to10;

	@Column(name = "message")
	private String message;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    
    // game
    @Column(name = "game")
    private int game;

	
	/*
	 * add below to Player
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private List<PlayerGameRatings> playerGameRatings;    
    
	 * 
	 */
	
}
