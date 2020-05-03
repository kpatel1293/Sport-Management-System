package edu.depaul.cdm.se.sportmanagementsystem.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter @Setter 
public class PlayerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private String age;
    
    
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    public ManagersEntity manager;
    
    
    
}
