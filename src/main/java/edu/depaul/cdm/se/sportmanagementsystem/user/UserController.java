package edu.depaul.cdm.se.sportmanagementsystem.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    // get all user
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // get user
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userService.getUser(userId);

        return ResponseEntity.ok().body(user);
    }

    // create user
    @PostMapping
    public ResponseEntity<Long> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);

        return ResponseEntity.ok().body(user.getId());
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);

        return ResponseEntity.ok().body(updatedUser);
    }

    // delete user
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);

        userService.deleteUser(user);

        Map<String, Boolean> resp = new HashMap<>();
        resp.put("deleted", Boolean.TRUE);

        return resp;
    }
}
