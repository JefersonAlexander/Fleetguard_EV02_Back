package com.microservice.fleetLocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.microservice.fleetLocation")
public class MicroserviceFleetLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceFleetLocationApplication.class, args);
	}

}
