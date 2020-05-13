package edu.depaul.cdm.se.sportmanagementsystem.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // get all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    // get one user (by id)
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    // get by email
    public User getUserEmail(String email) {
        return userRepository.findById(userRepository.findByEmail(email).getId()).get();
    }

    // save user
    public User saveUser(User user) {


        return userRepository.save(user);
    }

    public User updateUser(Long userID, User user) {
        user.setId(userID);
        
        user.setAddress(userRepository.findById(userID).get().getAddress());

        return userRepository.save(user);
    }

    // delete user
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}