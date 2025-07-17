package com.microservice.fleetLocation.service; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.fleetLocation.DTO.UserDTO;
import com.microservice.fleetLocation.mapper.UserMapper;
import com.microservice.fleetLocation.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Get all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

}
