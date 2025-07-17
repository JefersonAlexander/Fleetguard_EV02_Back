package com.fleetGuard360.api_gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;



@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://fleet-guar360.vercel.app")
                .allowedMethods("GET", "POST", "PUT", "PATCH")
                .allowedHeaders("Authorization", "Content-Type");
    }
}