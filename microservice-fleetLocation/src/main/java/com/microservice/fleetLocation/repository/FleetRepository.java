package com.microservice.fleetLocation.repository;
import com.microservice.fleetLocation.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface FleetRepository extends JpaRepository<Fleet, Long> {
    
}
