package com.microservice.fleetLocation.entity;


import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import com.microservice.fleetLocation.listener.UserRevisionListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// This entity is used to store user information when making changes, 
//such as deleting and creating, to the TransportUnit, User, and Fleet 
//entities. This entity is created to relate a user to a change.
@Entity
@RevisionEntity(UserRevisionListener.class)
@Table(name = "user_audit")
public class UserAuditEntity extends DefaultRevisionEntity  {
    @Column(nullable = false)
    private String username;


    public String getUsername() {
        return username; 
    }

    public String setUsername(String username) {
        this.username = username;
        return this.username;
    }

}
