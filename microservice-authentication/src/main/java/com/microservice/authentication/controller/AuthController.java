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

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterRequest request) {
        try {
            UserDTO result = authService.register(request);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest request) {
        LoginResponse result  = authService.login(request);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                    .body("Incorrect credentials.");
        }

        return ResponseEntity.ok(result);
    }
}
