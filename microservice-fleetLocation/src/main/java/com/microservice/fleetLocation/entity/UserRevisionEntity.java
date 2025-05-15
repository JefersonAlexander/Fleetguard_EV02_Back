package com.microservice.fleetLocation.entity;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import com.microservice.fleetLocation.listener.UserRevisionListener;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@RevisionEntity(UserRevisionListener.class)
@Table(name = "revinfo")
public class UserRevisionEntity extends DefaultRevisionEntity  {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
