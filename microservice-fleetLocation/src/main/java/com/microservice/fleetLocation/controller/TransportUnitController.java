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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transport Units", description = "Endpoints para gestionar unidades de transporte")
@RestController
@RequestMapping("/api/fleetLocation/transportUnit")
public class TransportUnitController {
    
    private final TransportUnitService transportUnitFacade;

    public TransportUnitController(TransportUnitService transportUnitFacade) {
        this.transportUnitFacade = transportUnitFacade;
    }

    // Get all transport units
    @Operation(summary = "Obtener unidades de transporte", description = "Se obtiene una lista con todas las unidades de transporte")
    @GetMapping 
    public ResponseEntity<List<TransportUnitDetailDTO>> getAllTransportUnits() {
        return ResponseEntity.ok(transportUnitFacade.getAllTransportUnits());
    }

    // Create a new transport unit
    @Operation(summary = "Crear unidad de transporte", description = "Se crea una nueva unidad de transporte")
    @PostMapping("/create")
    public ResponseEntity<TransportUnitDetailDTO> createTransportUnit(@RequestBody @Validated TransportUnitDTO transportUnitDTO) {
      
        return ResponseEntity.status(HttpStatus.CREATED).body(transportUnitFacade.createTransportUnit(transportUnitDTO));
    }

    // Update a transport unit
    @Operation(summary = "Actualizar unidad de transporte", description = "Se actualiza una unidad de transporte existente por ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<TransportUnitDetailDTO> updateTransportUnit(@PathVariable Long id,@RequestBody @Validated TransportUnitDTO transportUnitDTO) {
        return ResponseEntity.ok(transportUnitFacade.updateTransportUnit(id, transportUnitDTO));
    }

    //Delete a transport unit logically
    @Operation(summary = "Eliminar unidad de transporte", description = "Se eliminar una unidad de transporte de forma lógica por ID")
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> logicallyDelete(@PathVariable Long id) {
        transportUnitFacade.logicallyDeleteTransportUnit(id);
        return ResponseEntity.noContent().build(); 
    }

}
