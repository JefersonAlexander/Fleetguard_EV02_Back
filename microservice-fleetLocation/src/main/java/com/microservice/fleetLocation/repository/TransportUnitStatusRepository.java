package com.microservice.fleetLocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.fleetLocation.entity.TransportUnitStatus;

@Repository
public interface TransportUnitStatusRepository extends JpaRepository<TransportUnitStatus, Long> {
    
} 
