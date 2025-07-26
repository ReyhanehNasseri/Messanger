package com.example.messenger.controller;

import com.example.messenger.model.User;
import com.example.messenger.service.UserManager;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager){
        this.userManager = userManager;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userManager.addUser(user);
    }

    @PutMapping(path = "/{userId}")
    public void updateUserName(@PathVariable("userId") String userId , @RequestParam String name){
        System.out.println(userId);
        userManager.updateUserName(name , userId);
    }
    @DeleteMapping(path = "/{userId}")
    public void removeUser(@PathVariable("userId") String userId){
        userManager.removeUser(userId);
    }

    @GetMapping
    public List<User> getUsers(){
        return userManager.getUsers();
    }
}
