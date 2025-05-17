package com.microservice.fleetLocation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import jakarta.persistence.*;



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

    @Column(nullable = false)
    private Long capacity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User driver;

    @ManyToOne 
    @JoinColumn(name = "fleet_id", nullable = false) 
    private Fleet fleet; 
    
    
    @Column(nullable = false) 
    private boolean active;
    
    
    @Column(nullable = false) 
    private boolean deleted;
    
}

