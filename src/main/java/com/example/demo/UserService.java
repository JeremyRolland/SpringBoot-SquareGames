package com.example.demo;

import java.util.UUID;

public interface UserService {
    User createUser(User user);
    User getUser(UUID userId);
}
