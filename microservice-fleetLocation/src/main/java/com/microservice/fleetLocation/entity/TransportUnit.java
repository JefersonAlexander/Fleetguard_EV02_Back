package com.microservice.fleetLocation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transport_units")
public class TransportUnit {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false, length = 50) 
    private String licence; 

    @Column(nullable = false) 
    private Long model; 

    @ManyToOne 
    @JoinColumn(name = "id_user", nullable = false)
    private User driver;


    @ManyToOne 
    @JoinColumn(name = "id_fleet", nullable = false) 
    private Fleet fleet; 

    @Column(name = "is_active", nullable = false) 
    private boolean isActive; 
    
}

