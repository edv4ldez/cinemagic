package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Auth;
import com.metaphorce.cinemagic.entities.User;
import com.metaphorce.cinemagic.services.AuthService;
import com.metaphorce.cinemagic.services.AuthServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public void test(@RequestBody User user) {
        System.out.println("hola");
    }

    @PostMapping("/login")
    public ResponseEntity<Auth> login(@RequestBody User user) {
        Auth auth = authService.login(user);
        System.out.println(auth.toString());
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    public ResponseEntity<Auth> register(@RequestBody User user) {
        System.out.println(user.toString());
        Auth auth = authService.register(user);
        return ResponseEntity.ok(auth);
    }
}
