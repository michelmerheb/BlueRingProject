package org.example.bluering.controller;
import org.example.bluering.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.bluering.service.UserService;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    //Create or update the entire user
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }

    //Partially update a user
    @PatchMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return userService.updateUser(id, updates);
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
