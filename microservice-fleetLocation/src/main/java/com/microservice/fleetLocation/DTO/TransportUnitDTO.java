package com.microservice.fleetLocation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservice.fleetLocation.entity.Fleet;
import com.microservice.fleetLocation.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportUnitDTO {
    
    private Long id;
    private String licence; 
    private Long model; 
    private User driver;
    private Fleet fleet; 
    private boolean isActive; 
    
}
