package com.mcit.dockerdemo.controller;

import com.mcit.dockerdemo.entity.User;
import com.mcit.dockerdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        Optional<User> user = userService.findUserById(id);
        return ResponseEntity.ok(user.get());
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user1){
        User user = userService.saveUser(user1);
        return ResponseEntity.ok(user);
    }
}
