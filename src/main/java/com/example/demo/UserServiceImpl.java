package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final Map<UUID, User> users = new HashMap<>();

    @Override
    public User createUser(UserCreationParams params) {
        UUID userId = UUID.randomUUID();
        User user = new User(userId, params.getEmail(),params.getPassword());
        users.put(userId, user);
        return user;
    }

    @Override
    public UserDto getUser(UUID userId) {
        User user = users.get(userId);
        UserDto userDto = new UserDto(user.getId(),user.getEmail());
        return userDto;
    }
}
