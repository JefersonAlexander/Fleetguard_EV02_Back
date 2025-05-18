package com.microservice.authentication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.authentication.repository.UserRepository;

@Configuration
public class JwtConfig {
     @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(UserRepository userRepository) {
        return new JwtAuthenticationFilter(userRepository);
    }
}
