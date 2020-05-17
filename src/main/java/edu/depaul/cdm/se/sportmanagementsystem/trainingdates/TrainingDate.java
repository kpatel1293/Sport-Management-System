package edu.depaul.cdm.se.sportmanagementsystem.trainingdates;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.depaul.cdm.se.sportmanagementsystem.teams.Team;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_name")
    private Team team;
	
	@Column(name = "train_date")
	public Date date;
}
