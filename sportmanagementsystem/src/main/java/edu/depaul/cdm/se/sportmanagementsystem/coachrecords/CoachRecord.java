package edu.depaul.cdm.se.sportmanagementsystem.coachrecords;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "coachrecords")
public class CoachRecord implements Serializable {
    private static final long serialVersionUID = 5L;
    
    @Id
    @Column(name = "coach_id")
    private Long id;

    // rating
    @Column(name = "name")
    private String name;
}