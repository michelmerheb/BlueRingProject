package org.example.bluering.service;
import org.example.bluering.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.bluering.repository.UserRepository;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Add or update User
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    //Partial update
    public User updateUser(int id, Map<String, Object> updates) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Apply updates to the fields provided in the map
        updates.forEach((key, value) -> {
            switch (key) {
                case "username":
                    user.setUsername(value.toString());
                    break;
                case "email":
                    user.setEmail(value.toString());
                    break;
                case "age":
                    user.setAge(Integer.parseInt(value.toString()));
                    break;
                case "isActive":
                    user.setIsActive(Boolean.parseBoolean(value.toString()));
                    break;
            }
        });
        return userRepository.save(user);
    }

    //Find user by id
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    //Delete user by id
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

}
