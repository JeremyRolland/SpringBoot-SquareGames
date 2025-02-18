package com.example.demo;

import java.util.UUID;

public class UserDto {
    private final UUID id;
    private String email;

    public UserDto(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
