package edu.depaul.cdm.se.sportmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private Long addressID;

    private String addressOne;
    private String addressTwo;

    private int zipcode;

    private String city;

    private String state;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
