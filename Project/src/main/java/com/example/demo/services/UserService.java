package com.example.demo.services;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findByUsernameAndPassword(String username, String password) throws ItemNotFoundException{
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new ItemNotFoundException("User could not be found"));
    }

    public User createNewUser(User user) throws Exception {
        return userRepository.save(user);
    }

    public void updatePermissionsByUsername(String username, String permissions) throws Exception {
        userRepository.updatePermissionsByUsername(username, permissions);
    }

    public void deleteUser(String username) throws Exception{
        userRepository.deleteById(username);
    }

}
