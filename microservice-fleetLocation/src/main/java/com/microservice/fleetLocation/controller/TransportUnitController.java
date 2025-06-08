package com.microservice.fleetLocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import com.microservice.fleetLocation.DTO.TransportUnitDetailDTO;
import com.microservice.fleetLocation.service.TransportUnitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/fleetLocation/transportUnit")
public class TransportUnitController {
    
    private final TransportUnitService transportUnitFacade;

    public TransportUnitController(TransportUnitService transportUnitFacade) {
        this.transportUnitFacade = transportUnitFacade;
    }

    // Get all transport units
    @GetMapping 
    public ResponseEntity<List<TransportUnitDetailDTO>> getAllTransportUnits() {
        return ResponseEntity.ok(transportUnitFacade.getAllTransportUnits());
    }

    // Create a new transport unit
    @PostMapping("/create")
    public ResponseEntity<TransportUnitDetailDTO> createTransportUnit(@RequestBody @Validated TransportUnitDTO transportUnitDTO) {
      
        return ResponseEntity.status(HttpStatus.CREATED).body(transportUnitFacade.createTransportUnit(transportUnitDTO));
    }

    // Update a transport unit
    @PutMapping("/update/{id}")
    public ResponseEntity<TransportUnitDTO> updateTransportUnit(@PathVariable Long id,@RequestBody @Validated TransportUnitDTO transportUnitDTO) {
        return ResponseEntity.ok(transportUnitFacade.editTransportUnit(id, transportUnitDTO));
    } 

    @PatchMapping("/delete/{id}")
    public ResponseEntity<TransportUnitDTO> logicallyDelete(@PathVariable Long id) {
        TransportUnitDTO updatedDTO = transportUnitFacade.logicallyDeleteTransportUnit(id);
        return ResponseEntity.ok(updatedDTO);
    }
}
