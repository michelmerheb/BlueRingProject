package org.example.bluering.controller;
import org.example.bluering.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.bluering.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    //Create or update user
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }

    //Get a user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    //Delete a user by id
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
