package edu.depaul.cdm.se.sportmanagementsystem.krishna.user;

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
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    // get one user (by id)
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    // save/update user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // delete user
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}