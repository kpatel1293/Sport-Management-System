package edu.depaul.cdm.se.sportmanagementsystem.jack.injuries;

// TODO: Eliminate extra imports ...
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "player_id")
	public int playerId;
}
