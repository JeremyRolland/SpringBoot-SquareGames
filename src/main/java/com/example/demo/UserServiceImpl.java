package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User createUser(User user) {
       return userDao.upsert(user);
    }

    @Override
    public User getUser(UUID userId) {
        return userDao.findById(userId).get();
    }
}
