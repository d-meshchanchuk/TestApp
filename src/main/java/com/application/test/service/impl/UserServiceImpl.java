package com.application.test.service.impl;

import com.application.test.model.Role;
import com.application.test.model.Status;
import com.application.test.model.User;
import com.application.test.repository.RoleRepository;
import com.application.test.repository.UserRepository;
import com.application.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);

        if (result == null) {
            log.warn("IN findByUserName - no user found by username: {}", username);
        }

        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);

        if (result.isPresent()) {
            log.warn("IN findById - no user found by id: {}", id);
            throw new RuntimeException();
        }

        log.info("IN findById - user: {} found by id: {}", result, id);
        //todo что-нибудь придумать
        return result.get();
    }

    @Transactional
    @Override
    public void save(User user) {
        User registeredUser = userRepository.save(user);
        log.info("IN save - tariff: {} successfully created", registeredUser);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }
}
