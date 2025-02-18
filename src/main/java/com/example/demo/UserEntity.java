package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    public UUID id;
    public @NotNull @Email String email;
    public @NotNull String password;

    public UserEntity() {}

    public UserEntity(UUID id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
