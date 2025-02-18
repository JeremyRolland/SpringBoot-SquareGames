package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Qualifier("jpaUserDao")
    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
       return userDao.upsert(user);
    }

    @Override
    public User getUser(UUID userId) {
        return userDao.findById(userId).get();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll().collect(Collectors.toList());
    }

    @Override
    public void deleteUser(UUID userId) {
        userDao.delete(userId);
    }
}
