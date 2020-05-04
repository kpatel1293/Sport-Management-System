package edu.depaul.cdm.se.sportmanagementsystem.jack.trainingdates;

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
@Table(name = "trainingdates")
public class TrainingDate implements Serializable{
	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "team_id")
	public int teamId;
	
	@Column(name = "train_date")
	public Date date;
}
