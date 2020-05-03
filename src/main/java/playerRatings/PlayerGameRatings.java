package playerRatings;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerGameRatings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private int rating1to10;
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
