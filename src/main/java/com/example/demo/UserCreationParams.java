package com.example.demo;

import org.jetbrains.annotations.NotNull;

public class UserCreationParams {
    @NotNull
    private String email;

    @NotNull
    private String password;

    public UserCreationParams() {
    }

    public UserCreationParams(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
