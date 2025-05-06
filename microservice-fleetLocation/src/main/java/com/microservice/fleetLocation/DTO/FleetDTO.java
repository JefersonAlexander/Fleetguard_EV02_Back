package com.microservice.fleetLocation.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class FleetDTO {
    private Long id;
    private String name;
    private String description;
}


