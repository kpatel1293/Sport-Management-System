package edu.depaul.cdm.se.sportmanagementsystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "managers")
@Getter @Setter
public class ManagersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "team")
    private String team;
    
    @OneToMany(
    		mappedBy= "manager",
    		cascade = CascadeType.ALL,
    		fetch = FetchType.LAZY,
    		targetEntity = PlayerEntity.class
    		)
   private List<PlayerEntity> listPlayers;
   //private ; 
    
   }
