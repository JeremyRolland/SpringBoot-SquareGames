package com.example.demo;

import java.util.UUID;

public interface UserService {
    User createUser(UserCreationParams params);
    UserDto getUser(UUID userId);
}
