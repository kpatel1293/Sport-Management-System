package edu.depaul.cdm.se.sportmanagementsystem.user.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // address id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // street 1
    @Column(name = "street_main")
    private String streetOne;

    // street 2
    @Column(name = "street_opt")
    private String streetTwo;

    // zipcode
    @Column(name = "zipcode")
    private String zipcode;

    // city
    @Column(name = "city")
    private String city;

    // state
    @Column(name = "state")
    private String state;
}