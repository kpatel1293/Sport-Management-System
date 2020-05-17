package edu.depaul.cdm.se.sportmanagementsystem.injuries;

// TODO: Eliminate extra imports ...
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

@Data
@Entity
@Table(name = "injuries")
public class Injury implements Serializable{
	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
	public Player player;
}
