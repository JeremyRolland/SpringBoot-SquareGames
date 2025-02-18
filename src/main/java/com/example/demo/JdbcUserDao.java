package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class JdbcUserDao implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public @NotNull Stream<User> findAll() {
        String sql = "SELECT * FROM users";
        Map<String, Object> params = new HashMap<>();
        return namedParameterJdbcTemplate.queryForStream(sql, params, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Optional<User> findById(@NotNull UUID id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        Map<String, Object> params = Map.of("id", id.toString());

        try {
            User user = namedParameterJdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(User.class));
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public @NotNull User upsert(@NotNull User user) {
        // Vérifier si l'ID existe dans la base de données
        String checkSql = "SELECT COUNT(*) FROM users WHERE id = :id";
        Map<String, Object> checkParams = Map.of("id", user.getId().toString());
        Integer count = namedParameterJdbcTemplate.queryForObject(checkSql, checkParams, Integer.class);

        String sql;
        UUID id = user.getId() != null ? user.getId() : UUID.randomUUID();
        Map<String, Object> params = Map.of(
                "password", user.getPassword(),
                "email", user.getEmail(),
                "id", id.toString()
        );

        if (count != null && count > 0) {
            // Mise à jour
            sql = "UPDATE users SET email = :email, password = :password WHERE id = :id";
        } else {
            // Insertion
            sql = "INSERT INTO users (email, password, id) VALUES (:email, :password, :id)";
        }

        namedParameterJdbcTemplate.update(sql, params);
        return user;
    }

    @Override
    public void delete(@NotNull UUID user_id) {
        String sql = "DELETE FROM users WHERE id = :user_id";
        Map<String, Object> params = Map.of("id", user_id);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
