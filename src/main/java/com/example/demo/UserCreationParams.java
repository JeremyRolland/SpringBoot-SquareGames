package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class UserCreationParams {

    private @NotNull @Email String email;
    private @NotEmpty String password;

    public UserCreationParams() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
