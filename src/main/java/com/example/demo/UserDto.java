package com.example.demo;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String email;

    public UserDto(UUID id, String email) {
        this.id = id;
        this.email = email;
    }
}
