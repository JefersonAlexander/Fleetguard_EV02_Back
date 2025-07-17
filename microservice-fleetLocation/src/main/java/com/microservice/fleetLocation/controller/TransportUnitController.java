package com.microservice.fleetLocation.controller;


import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import com.microservice.fleetLocation.DTO.TransportUnitDetailDTO;
import com.microservice.fleetLocation.service.TransportUnitService;



public class TransportUnitController {
    
    private final TransportUnitService transportUnitFacade;

    public TransportUnitController(TransportUnitService transportUnitFacade) {
        this.transportUnitFacade = transportUnitFacade;
    }
 

    // Get all transport units
    @QueryMapping
    public List<TransportUnitDetailDTO> getAllTransportUnits() {
        return transportUnitFacade.getAllTransportUnits();
    }


    // Create a new transport unit
    @MutationMapping
    public TransportUnitDetailDTO createTransportUnit(@Argument TransportUnitDTO transportUnitDTO) {

        return transportUnitFacade.createTransportUnit(transportUnitDTO);
    }

    // Mutación: actualizar una unidad de transporte
    @MutationMapping
    public TransportUnitDetailDTO updateTransportUnit(@Argument Long id, @Argument TransportUnitDTO transportUnitDTO) {
        return transportUnitFacade.updateTransportUnit(id, transportUnitDTO);
    }

    // Mutación: eliminación lógica
    @MutationMapping
    public Boolean logicallyDelete(@Argument Long id) {
        transportUnitFacade.logicallyDeleteTransportUnit(id);
        return true;
    }

}
