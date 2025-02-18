package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class UserCreationParams {

    private final @NotNull @Email String email;
    private final @NotEmpty String password;

    public UserCreationParams(@NotNull String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
