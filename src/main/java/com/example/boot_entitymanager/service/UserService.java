package com.example.boot_entitymanager.service;

import com.example.boot_entitymanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    Optional<User> getUserById(Long id);
    void removeUser(Long id);
    void updateUser(User user);
   Optional<User> findByEmail(String email);
}
