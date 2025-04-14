package com.example.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.model.User;
import com.example.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return authService.authenticate(user.getUsername(), user.getPassword());
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean success = authService.register(user.getUsername(), user.getPassword());
        return success ? "User registered successfully" : "User already exists";
    }
}