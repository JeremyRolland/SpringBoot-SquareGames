package com.example.demo;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(User user);
    User getUser(UUID userId);
    List<User> findAll();
    void deleteUser(UUID userId);
}

