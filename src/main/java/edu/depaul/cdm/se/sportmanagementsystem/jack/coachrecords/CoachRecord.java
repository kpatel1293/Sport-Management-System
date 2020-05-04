package edu.depaul.cdm.se.sportmanagementsystem.jack.coachrecords;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se.sportmanagementsystem.krishna.user.User;
import lombok.Data;

@Data
@Document(collection = "coachrecords")
public class CoachRecord implements Serializable {
    private static final long serialVersionUID = 5L;
    
    @Id
    @Column(name = "coach_id")
    private int id;

    // rating
    @Column(name = "name")
    private String name;
}