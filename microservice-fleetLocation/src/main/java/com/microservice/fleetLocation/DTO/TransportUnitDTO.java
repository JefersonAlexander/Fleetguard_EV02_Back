package com.microservice.fleetLocation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
public class TransportUnitDTO {
    
    @NotBlank(message = "Licence is required")
    @Size(max = 8, message = "Licence cannot exceed 8 characters")
    private String licencePlate; 

    @NotNull(message = "Model is required")
    private String model; 

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be a positive number")
    @Max(value = 100, message = "Capacity must be a 3-digit number")
    private Long capacity;
     
    @Positive(message = "Driver ID must be a positive number")
    @NotNull(message = "Driver ID is required")
    private Long driverId;

    @Positive(message = "Fleet ID must be a positive number")
    @NotNull(message = "Fleet ID is required")
    private Long fleetId;

    @NotNull(message = "Status is required")
    private Long statusId;
    
    @JsonIgnore
    private Boolean deleted;
    
}
