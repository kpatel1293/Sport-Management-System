package edu.depaul.cdm.se.sportmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.model.User;
import edu.depaul.cdm.se.sportmanagementsystem.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	// get a user
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	// get all users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}
	
	// save user
	@PostMapping("/users")
	public Long saveUser(@RequestBody User user) {
		userService.addUser(user);
		
		return user.getUserID();
	}
	
	// delete user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
}
