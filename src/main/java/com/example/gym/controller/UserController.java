package com.example.gym.controller;

import com.example.gym.entity.User;
import com.example.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userDb=userService.getUserByUsername(user.getUsername());
        if(userDb!= null)
        if(userDb.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok(userDb);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
}
