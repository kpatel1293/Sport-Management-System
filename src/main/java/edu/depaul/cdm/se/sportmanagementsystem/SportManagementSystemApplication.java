package edu.depaul.cdm.se.sportmanagementsystem;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.depaul.cdm.se.sportmanagementsystem.managers.Managers;
import edu.depaul.cdm.se.sportmanagementsystem.managers.ManagersRepository;
import edu.depaul.cdm.se.sportmanagementsystem.managers.ManagersService;
import edu.depaul.cdm.se.sportmanagementsystem.player.Player;
import edu.depaul.cdm.se.sportmanagementsystem.player.PlayerRepository;
import edu.depaul.cdm.se.sportmanagementsystem.teams.Team;
import edu.depaul.cdm.se.sportmanagementsystem.teams.TeamRepository;
import edu.depaul.cdm.se.sportmanagementsystem.user.TypeOfUser;
import edu.depaul.cdm.se.sportmanagementsystem.user.User;
import edu.depaul.cdm.se.sportmanagementsystem.user.UserRepository;
import edu.depaul.cdm.se.sportmanagementsystem.user.address.Address;

@SpringBootApplication
public class SportManagementSystemApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SportManagementSystemApplication.class, args);
	}
	
	@Autowired
	private ManagersRepository managersRepo;
	
	@Autowired
	private ManagersService managerService; 
	
	@Autowired
	private PlayerRepository playersRepo;
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private UserRepository userRepo;
	
	
	@Override 
	public void run(String ...args) throws Exception{
		
		Team bulls = new Team();
		bulls.setCityName("Chicago");
		bulls.setTeamName("Bulls");
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		User user = new User();
		String dob1 = "02-02-1965";
		java.util.Date date = dateFormat.parse(dob1);
		user.setDob(date);
		user.setFirstName("michael");
		user.setId(3L);
		user.setLastName("jordan");
		user.setUserType(TypeOfUser.PLAYER);
		

		User user2 = new User();
		user2.setFirstName("Scottie");
		user2.setLastName("Pippen");
		user2.setUserType(TypeOfUser.PLAYER);
		String dob2 = "01-01-1975";
		java.util.Date date2 = dateFormat.parse(dob2);
		user2.setDob(date2);
		
		User user3 = new User();
		user3.setFirstName("Dennis");
		user3.setLastName("Rodman");
		user3.setUserType(TypeOfUser.PLAYER);
		String dob3 = "03-03-1975";
		java.util.Date date3 = dateFormat.parse(dob3);
		user3.setDob(date3);
		
		Managers jackson = new Managers();
		jackson.setId((long) 1);
		jackson.setTeam(bulls);

		//jackson.setUser(user);
		
		
		Player jordan = new Player();
		jordan.setId(1);
		jordan.setIsActive(true);
		jordan.setManager(jackson);
		jordan.setTeam(bulls);
		jordan.setUser(user);
		
		Player pippen = new Player();
		pippen.setId(2);
		pippen.setIsActive(true);
		pippen.setManager(jackson);
		pippen.setTeam(bulls);
		pippen.setUser(user2);
		
		Player rodman = new Player();
		rodman.setManager(jackson);
		rodman.setUser(user3);
		rodman.setTeam(bulls);
		rodman.setId(3);
		rodman.setIsActive(true);

		
		managersRepo.save(jackson);
		teamRepo.save(bulls);
		
		playersRepo.save(jordan);
		playersRepo.save(pippen);
		playersRepo.save(rodman);
		
		
		
		
		
	}
	
	
}
