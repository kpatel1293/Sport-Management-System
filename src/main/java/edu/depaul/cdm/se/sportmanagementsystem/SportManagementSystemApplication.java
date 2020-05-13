package edu.depaul.cdm.se.sportmanagementsystem;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportManagementSystemApplication {
	public static void main(String[] args) {
		// Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:SportManagement", "sa", null).load();
		flyway.clean();
        // Start the migration
        flyway.migrate();
		SpringApplication.run(SportManagementSystemApplication.class, args);
	}
}
