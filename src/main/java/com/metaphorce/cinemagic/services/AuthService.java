package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Auth;
import com.metaphorce.cinemagic.entities.User;
import com.metaphorce.cinemagic.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AuthService implements AuthServiceI {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Auth login(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        UserDetails userDetails = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.getToken(userDetails);
        Auth auth = new Auth();
        auth.setToken(token);
        return auth;
    }

    @Override
    public Auth register(User user) {
        User userToSave = new User();
        userToSave.setName(user.getName()); // Set the name
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt the password
        userToSave.setUserType(user.getUserType());
        userToSave.setRegistrationDate(new Timestamp(System.currentTimeMillis())); // Set the registration date
        userRepository.save(userToSave);

        UserDetails userDetails = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found after registration"));
        String token = jwtService.getToken(userDetails);

        Auth auth = new Auth();
        auth.setToken(token);
        return auth;
    }
}
