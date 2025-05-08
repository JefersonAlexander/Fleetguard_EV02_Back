package com.microservice.fleetLocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.fleetLocation.DTO.FleetDTO;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import com.microservice.fleetLocation.service.TransportUnitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/transportUnit")
public class TransportUnitController {
    
    private final TransportUnitService transportUnitFacade;

    public TransportUnitController(TransportUnitService transportUnitFacade) {
        this.transportUnitFacade = transportUnitFacade;
    }

    // Get all transport units
    @GetMapping 
    public ResponseEntity<List<TransportUnitDTO>> getAllTransportUnits() {
        return ResponseEntity.ok(transportUnitFacade.getAllTransportUnits());
    }

    // Create a new transport unit
    @PostMapping
    public ResponseEntity<TransportUnitDTO> createTransportUnit(@RequestBody TransportUnitDTO transportUnitDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transportUnitFacade.createTransportUnit(transportUnitDTO));

    }

    // Update a transport unit
    @PutMapping 
    public ResponseEntity<TransportUnitDTO> updateTransportUnit(@RequestBody TransportUnitDTO transportUnitDTO) {
        return ResponseEntity.ok(transportUnitFacade.editTransportUnit(transportUnitDTO.getId(), transportUnitDTO));
    
    }
}
