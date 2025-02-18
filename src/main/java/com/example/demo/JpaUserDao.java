package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class JpaUserDao implements UserDao {

    @Autowired
    private UserEntityRepository userRepository;

    @Override
    public @NotNull Stream<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(this::convertUserEntityToUser);
    }

    @Override
    public Optional<User> findById(@NotNull UUID id) {
       Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(this::convertUserEntityToUser);
    }

    @Override
    public @NotNull User upsert(@NotNull User user) {
        UserEntity userEntity = new UserEntity(user.getId(), user.getEmail(), user.getPassword());
        userEntity = userRepository.save(userEntity);
        return convertUserEntityToUser(userEntity);
    }

    @Override
    public void delete(@NotNull UUID id) {
        userRepository.deleteById(id);
    }

    private User convertUserEntityToUser(UserEntity userEntity) {
        return new User(userEntity.id, userEntity.email, userEntity.password);
    }
}
