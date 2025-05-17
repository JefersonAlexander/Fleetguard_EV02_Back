package com.microservice.fleetLocation.entity;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    
    @Column(nullable = false, length = 50)
    private String name;

    
    @Column(nullable = false, length = 50, unique = true) 
    private String email;
    
   
    @Column(nullable = false, length = 100)
    private String password;

    @Column(name = "role_id", nullable = false)
    private Long roleId; 

}
