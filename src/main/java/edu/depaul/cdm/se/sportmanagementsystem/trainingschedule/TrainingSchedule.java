package edu.depaul.cdm.se.sportmanagementsystem.trainingschedule;

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

@Entity
@Table(name = "training_schedule")
@Data
public class TrainingSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "training_date")
    private Date training_date;

    @Column(name = "location")
    private String city;

    @Column(name = "season")
    private int season;
}