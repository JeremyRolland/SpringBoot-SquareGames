package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreationParams params) {
        return userService.createUser(new User(UUID.randomUUID(), params.getEmail(), params.getPassword()));
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable UUID userId) {
        return new UserDto(userId, userService.getUser(userId).getEmail());
    }
}
