package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class InMemoryUserDao implements UserDao {

    private final List<User> users = new ArrayList<>();

    @Override
    public @NotNull Stream<User> findAll() {
        return users.stream();
    }

    @Override
    public Optional<User> findById(@NotNull UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public @NotNull User upsert(@NotNull User user) {
        users.add(user);
        return user;
    }

    @Override
    public void delete(@NotNull UUID id) {
        users.removeIf(user -> user.getId().equals(id));

    }
}
