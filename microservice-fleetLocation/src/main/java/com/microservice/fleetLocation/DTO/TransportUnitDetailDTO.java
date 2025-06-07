package com.microservice.fleetLocation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportUnitDetailDTO {
    private Long id;

    private String licencePlate;

    private String model;

    private Long capacity;

    private UserDTO driver; 

    private FleetDTO fleet; 

    private TransportUnitStatusDTO status; 

    @JsonIgnore
    private Boolean deleted;
}
