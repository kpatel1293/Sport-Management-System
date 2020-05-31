package edu.depaul.cdm.se.sportmanagementsystem.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.depaul.cdm.se.sportmanagementsystem.managers.Managers;
import edu.depaul.cdm.se.sportmanagementsystem.managers.ManagersService;
import edu.depaul.cdm.se.sportmanagementsystem.player.Player;
import edu.depaul.cdm.se.sportmanagementsystem.player.PlayerServices;
import edu.depaul.cdm.se.sportmanagementsystem.user.address.Address;
import edu.depaul.cdm.se.sportmanagementsystem.user.address.AddressService;

@Controller
// @RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    PlayerServices playerServices;

    @Autowired
    ManagersService managerService;

    @Autowired
    AddressService addressService;

    // login
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
// 'admin@admin.com', 'ADMIN'
    @PostMapping("/login")
    public String succ(@ModelAttribute User user) {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty())
            return "redirect:/login";
        
        // User u = userService.getUserEmail(user.getEmail());

        // if(u.getId().equals(null))
        //     return "redirect:/login";

        // System.out.println("################");
        // System.out.println(user.toString());
        // System.out.println(u.toString());
        // System.out.println("################");

        return "redirect:/main";
    }

    // get all user
    // @GetMapping
    // public List<User> getUsers() {
    // return userService.getAllUsers();
    // }
    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user";
    }

    // get user
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable(value = "id") Long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        return "edit-user";
    }

    // create user
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user, @ModelAttribute Address address) {
        if (user.getFirstName().isEmpty())
            return "signup";
        if (user.getLastName().isEmpty())
            return "signup";
        if (user.getDob() == null)
            return "signup";
        if (user.getEmail().isEmpty())
            return "signup";
        if (user.getPassword().isEmpty())
            return "signup";

        userService.saveUser(user);

        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainAdmin(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "main";
    }
    

    // update user
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable(value = "id") Long userId, @ModelAttribute User user) {
        User u = userService.getUser(user.getId());
        if(user.getPassword().trim().isEmpty()) user.setPassword(u.getPassword());
        userService.updateUser(userId, user);

        return "redirect:/main";
    }

    // delete user
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);

        if(user.getUserType() == TypeOfUser.PLAYER) {
            Player player = playerServices.getPlayerByUser(user);
            player.setManager(null);
            player.setTeam(null);
            playerServices.deletePlayer(player);
        }
        
        if(user.getUserType() == TypeOfUser.MANAGER) {
            System.out.println(managerService.getManagerByUser(user));
            Managers manager = managerService.getManagerByUser(user);

            List<Player> players = playerServices.getPlayerByManager(manager);
            players.forEach(player -> {
                player.setManager(null);
            });

            manager.setTeam(null);
            managerService.deleteManager(manager);
        }

        userService.deleteUser(user);

        // Map<String, Boolean> resp = new HashMap<>();
        // resp.put("deleted", Boolean.TRUE);
        // System.out.println("RESP DELETE --- " + resp);

        return "redirect:/main";
    }

    @GetMapping("/users/create")
    public String createUserAdmin(Model model) {
        model.addAttribute("user", new User());

        return "create-user";
    }

    @PostMapping("/users/create")
    public String createUserPost(@ModelAttribute User user, @ModelAttribute Address address) {
        if (user.getFirstName().isEmpty())
            return "create-user";
        if (user.getLastName().isEmpty())
            return "create-user";
        if (user.getDob() == null)
            return "create-user";
        if (user.getEmail().isEmpty())
            return "create-user";
        if (user.getPassword().isEmpty())
            return "create-user";

        userService.saveUser(user);

        return "redirect:/main";
    }
}
