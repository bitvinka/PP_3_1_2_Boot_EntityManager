package com.example.boot_entitymanager.dao;

import com.example.boot_entitymanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
   void addUser(User user);
   List<User> getUsers();
   Optional <User> getUserById(Long id);

   void removeUser(Long id);
   void updateUser(User user);
   Optional<User> findByEmail(String email);

}
