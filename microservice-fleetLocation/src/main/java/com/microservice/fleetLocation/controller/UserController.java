package com.microservice.fleetLocation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.fleetLocation.DTO.UserDTO;
import com.microservice.fleetLocation.service.UserService;

@RestController
@RequestMapping("/api/fleetLocation/user")
public class UserController {

    private final UserService userFacade;

    public UserController(UserService userFacade) {
        this.userFacade = userFacade;
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userFacade.getAllUsers());
    }

    
}
