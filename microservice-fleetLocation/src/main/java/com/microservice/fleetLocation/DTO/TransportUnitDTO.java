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
    
    private Long id;

    @NotBlank(message = "Licence is required")
    @Size(max = 8, message = "Licence cannot exceed 8 characters")
    private String licencePlate; 

    @NotNull(message = "Model is required")
    @Min(value = 1000, message = "The model must be a positive number of 4 digits")
    @Max(value = 9999, message = "Model must be a 4-digit number")
    private Long model; 
     
    @Positive(message = "Driver ID must be a positive number")
    @NotNull(message = "Driver ID is required")
    private Long driverId;

    @Positive(message = "Fleet ID must be a positive number")
    @NotNull(message = "Fleet ID is required")
    private Long fleetId;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @JsonIgnore
    private Boolean deleted;
    
}
