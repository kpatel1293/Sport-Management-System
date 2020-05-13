package edu.depaul.cdm.se.sportmanagementsystem.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
// @RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    // login
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String succ(@ModelAttribute User user) {
        if(userService.getUserEmail(user.getEmail()).equals(null))
            return "redirect:/login";
        return "main";
      }

    // // get all user
    // @GetMapping
    // public List<User> getUsers() {
    //     return userService.getAllUsers();
    // }

    // // get user
    // @GetMapping("/{id}")
    // public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
    //     User user = userService.getUser(userId);

    //     return ResponseEntity.ok().body(user);
    // }

    // create user
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);

        return "main";
    }

    // // update user
    // @PutMapping("/{id}")
    // public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User user) {
    //     User updatedUser = userService.updateUser(userId, user);

    //     return ResponseEntity.ok().body(updatedUser);
    // }

    // // delete user
    // @DeleteMapping("/{id}")
    // public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) {
    //     User user = userService.getUser(id);

    //     userService.deleteUser(user);

    //     Map<String, Boolean> resp = new HashMap<>();
    //     resp.put("deleted", Boolean.TRUE);

    //     return resp;
    // }
}
