package edu.depaul.cdm.se.sportmanagementsystem.playerratinglastgame;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

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
	private int rating1to10;

	@Column(name = "message")
	private String message;

	
	/*
	 * add below to Player
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private List<PlayerGameRatings> playerGameRatings;    
    
	 * 
	 */
	
}
