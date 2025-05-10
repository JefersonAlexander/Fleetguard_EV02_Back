package com.microservice.fleetLocation.entity;

import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Audited
@Table(name = "fleets")
public class Fleet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(nullable = false, length = 50)
    private String name;
    

    @Column(nullable = false, length = 200)
    private String description;
}
