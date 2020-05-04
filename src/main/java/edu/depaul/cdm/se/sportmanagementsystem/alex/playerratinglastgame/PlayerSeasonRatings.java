package edu.depaul.cdm.se.sportmanagementsystem.alex.playerratinglastgame;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSeasonRatings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private int rating1to10;
	private String message;

	
	/*
	 * add below to Player
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private List<PlayerSeasonRatings> playerSeasonRatings;    
    
	 * 
	 */
	

}
