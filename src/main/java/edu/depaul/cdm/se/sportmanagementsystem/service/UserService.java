package edu.depaul.cdm.se.sportmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se.sportmanagementsystem.model.User;
import edu.depaul.cdm.se.sportmanagementsystem.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	// get a user
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	// get all users
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		
		userRepository.findAll().forEach(user -> users.add(user));
		
		return users;
	}
	
	// add/update a user
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	// remove a user
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
