package com.example.demo.controllers;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String userTest(){
        return "~THIS IS A TEST~";
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User postNewUser(@RequestBody User newUser) throws Exception{
        return userService.createNewUser(newUser);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.FOUND)
    public User getUserByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password) throws ItemNotFoundException {
        return userService.findByUsernameAndPassword(username, password);
    }

    @GetMapping("/users/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<User> getAllUsers() throws ItemNotFoundException {
        return userService.getAllUsers();
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public void putNewPermissionsByUsername(@RequestParam("username") String username, @RequestParam("permissions") String permissions) throws Exception {
        userService.updatePermissionsByUsername(username, permissions);
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
