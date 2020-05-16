package edu.depaul.cdm.se.sportmanagementsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import edu.depaul.cdm.se.sportmanagementsystem.user.address.Address;
import edu.depaul.cdm.se.sportmanagementsystem.user.address.AddressService;

@Controller
// @RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

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

    // get all user
    // @GetMapping
    // public List<User> getUsers() {
    //     return userService.getAllUsers();
    // }
    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user";
    }

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
    public String createUser(@ModelAttribute User user, @ModelAttribute Address address) {
        System.out.println("HIITT");
        if(user.getFirstName().isEmpty()) return "signup";
        if(user.getLastName().isEmpty()) return "signup";
        if(user.getDob() == null) return "signup";
        if(user.getEmail().isEmpty()) return "signup";
        if(user.getPassword().isEmpty()) return "signup";
        // if(user.getAddress().getStreetOne().isEmpty()) return "signup";
        // if(user.getAddress().getStreetTwo().isEmpty()) return "signup";
        // if(user.getAddress().getCity().isEmpty()) return "signup";
        // if(user.getAddress().getState().isEmpty()) return "signup";
        // if(user.getAddress().getZipcode().isEmpty()) return "signup";

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
