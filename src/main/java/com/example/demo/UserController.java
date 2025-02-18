package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
