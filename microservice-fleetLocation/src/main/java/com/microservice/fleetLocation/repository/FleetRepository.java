package com.microservice.fleetLocation.repository;
import com.microservice.fleetLocation.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository 
public interface FleetRepository extends JpaRepository<Fleet, Long> {
    List<Fleet> findAll(); 
}
