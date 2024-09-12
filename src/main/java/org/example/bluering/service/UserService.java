package org.example.bluering.service;
import org.example.bluering.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.bluering.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Add or update User
    public User saveOrUpdateUser(User user) {
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
