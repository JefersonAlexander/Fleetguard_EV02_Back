package com.microservice.authentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.authentication.DTO.LoginRequest;
import com.microservice.authentication.DTO.LoginResponse;
import com.microservice.authentication.DTO.RegisterRequest;
import com.microservice.authentication.DTO.UserDTO;
import com.microservice.authentication.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody @Valid RegisterRequest request) {
        try {
            UserDTO userDTO = authService.register(request);
            return ResponseEntity.ok(userDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody @Valid LoginRequest request) {
        LoginResponse response = authService.login(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                    .body("Incorrect credentials.");
        }
        return ResponseEntity.ok(response);
    }
}
