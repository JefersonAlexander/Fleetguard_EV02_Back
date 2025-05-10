package com.microservice.fleetLocation.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.microservice.fleetLocation.DTO.FleetDTO;
import com.microservice.fleetLocation.service.FleetService;
import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/fleet")
public class FleetController {
    
    private final FleetService fleetFacade;

    public FleetController(FleetService fleetFacade) {
        this.fleetFacade = fleetFacade;
    }

    // Get all fleets
    @GetMapping
    public ResponseEntity<List<FleetDTO>> getAllFleets() {
        return ResponseEntity.ok(fleetFacade.getAllFleets());
    }

}

