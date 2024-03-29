package com.example.demo.services;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> getAllUsers() throws ItemNotFoundException {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) throws ItemNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new ItemNotFoundException("user could not be found"));
    }

    public void updateFilesUploadedByUsername(String username, ObjectId newUpload) throws ItemNotFoundException {
        User toUpdate = this.getUserByUsername(username);
        ArrayList<ObjectId> filesUploaded = toUpdate.getFilesUploaded();
        if(filesUploaded == null){
            filesUploaded = new ArrayList<ObjectId>();
        }
        filesUploaded.add(newUpload);

        userRepository.updateFilesUploadedByUsername(username, filesUploaded);
    }

    public void updateSpecificationsByUsername(String username, ObjectId newSpecification) throws ItemNotFoundException{
        User toUpdate = this.getUserByUsername(username);
        ArrayList<ObjectId> specifications = toUpdate.getSpecifications();
        if(specifications == null){
            specifications = new ArrayList<ObjectId>();
        }
        specifications.add(newSpecification);
        userRepository.updateSpecificationsByUsername(username, specifications);
    }
}
