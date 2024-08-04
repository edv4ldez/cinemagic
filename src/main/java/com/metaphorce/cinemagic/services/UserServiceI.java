package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserServiceI {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<Optional<User>> getUserByEmail(String email);
    List<User> getAllUsers();
    void deleteUserById(Long id);
}
