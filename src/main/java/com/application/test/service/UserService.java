package com.application.test.service;


import com.application.test.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    void save(User user);

    void delete(Long id);
}