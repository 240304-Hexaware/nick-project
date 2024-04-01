package com.example.demo.controllers;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.ReadFile;
import com.example.demo.models.Specification;
import com.example.demo.models.User;
import com.example.demo.services.FileService;
import com.example.demo.services.SpecificationService;
import com.example.demo.services.UserService;
import org.bson.types.ObjectId;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    private UserService userService;
    private FileService fileService;
    private SpecificationService specService;

    @Autowired
    public UserController(UserService userService, FileService fileService, SpecificationService specService) {
        this.userService = userService;
        this.fileService = fileService;
        this.specService = specService;
    }

    @GetMapping("/test")
    public String userTest(){
        return "~THIS IS A TEST~";
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User postNewUser(@RequestBody User newUser) throws Exception{
        System.out.println(newUser.getUsername());
        return userService.createNewUser(newUser);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password) throws ItemNotFoundException {
        return userService.findByUsernameAndPassword(username, password);
    }

    @GetMapping("/users/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserByUsername(@RequestParam("username") String username) throws ItemNotFoundException {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/users/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getAllUsers() throws ItemNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/users/files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ReadFile> getUsersFiles(@RequestParam("username") String username) throws ItemNotFoundException {
        User ourUser = this.getUserByUsername(username);
        return this.fileService.findAllFilesById(ourUser.getFilesUploaded());
    }

    @GetMapping("/users/specs")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Specification> getUsersSpecs(@RequestParam("username") String username) throws ItemNotFoundException {
        User ourUser = this.getUserByUsername(username);
        return this.specService.getAllSpecsById(ourUser.getSpecifications());
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void putNewPermissionsByUsername(@RequestParam("username") String username, @RequestParam("permissions") String permissions) throws Exception {
        userService.updatePermissionsByUsername(username, permissions);
    }

    @PutMapping("/users/file")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void putNewFilesUploadedByUsername(@RequestParam("username") String username, @RequestParam("newFileUploaded")ObjectId newFileUploaded) throws ItemNotFoundException {
        userService.updateFilesUploadedByUsername(username, newFileUploaded);
    }

    @PutMapping("/users/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void putNewSpecificationsByUsername(@RequestParam("username") String username, @RequestParam("specification")ObjectId spec) throws ItemNotFoundException{
        userService.updateSpecificationsByUsername(username, spec);
    }

    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@RequestParam("username") String username) throws Exception {
        userService.deleteUser(username);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String userException(Exception e){
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryItemNotFound(ItemNotFoundException e){
        System.out.println(e.getMessage());
        return e.getMessage();
    }

}
