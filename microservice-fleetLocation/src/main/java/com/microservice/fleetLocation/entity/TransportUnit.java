package com.microservice.fleetLocation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Table(name = "transport_units")
public class TransportUnit {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    
    @Column(nullable = false, length = 8, unique = true) 
    private String licencePlate;

    @Column(nullable = false)
    private Long model;

    @ManyToOne
    @NotNull(message = "Driver is required")
    @JoinColumn(name = "user_id", nullable = false)
    private User driver;

    @ManyToOne 
    @NotNull(message = "Fleet is required")
    @JoinColumn(name = "fleet_id", nullable = false) 
    private Fleet fleet; 
    
    @NotNull(message = "Active status is required")
    @Column(name = "is_active", nullable = false) 
    private boolean isActive;
    
    @NotNull(message = "Deleted status is required") 
    @Column(name = "deleted", nullable = false) 
    private boolean deleted;
    
}

