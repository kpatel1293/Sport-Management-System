package edu.depaul.cdm.se.sportmanagementsystem.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	private static final long serialVersionUID = 1L;

	// id
	@Id @GeneratedValue
	private Long userID;
	
	// name
	private String firstName;
	private String lastName;

	// dob
	// format : yyyy-MM-dd
	private Date dob;

	// login
	private String email;
	private String password;

	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;
}
