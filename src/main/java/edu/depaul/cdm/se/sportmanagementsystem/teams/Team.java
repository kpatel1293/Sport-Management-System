package edu.depaul.cdm.se.sportmanagementsystem.teams;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "teams")
public class Team implements Serializable{
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "team_name")
	public String teamName;
	
	@Column(name = "city_name")
	public String cityName;
	
	
	//@OneToMany 

}
