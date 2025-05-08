package com.microservice.fleetLocation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
public class TransportUnitDTO {
    
    private Long id;
    private String licence; 
    private Long model; 
    private Long driverId; 
    private Long fleetId;  
    private boolean isActive; 
    
}
