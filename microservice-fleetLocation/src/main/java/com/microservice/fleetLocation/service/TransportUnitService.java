package com.microservice.fleetLocation.service;
import com.microservice.fleetLocation.entity.Fleet;
import com.microservice.fleetLocation.entity.TransportUnit;
import com.microservice.fleetLocation.entity.User;
import  com.microservice.fleetLocation.mapper.TransportUnitMapper;
import com.microservice.fleetLocation.repository.FleetRepository;
import  com.microservice.fleetLocation.repository.TransportUnitRepository;
import com.microservice.fleetLocation.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TransportUnitService {
    
    private final TransportUnitRepository transportUnitRepository; 
    private final TransportUnitMapper  transportUnitMapper;
    private final UserRepository userRepository;
    private final FleetRepository fleetRepository;
    
    @Autowired
    public TransportUnitService(TransportUnitRepository transportUnitRepository, 
        TransportUnitMapper transportUnitMapper, UserRepository userRepository, FleetRepository fleetRepository) {
        
        this.transportUnitRepository = transportUnitRepository; 
        this.transportUnitMapper = transportUnitMapper;
        this.userRepository = userRepository;
        this.fleetRepository = fleetRepository;
    }
    
    // get all transport units
    public List<TransportUnitDTO> getAllTransportUnits() {

        return  transportUnitRepository.findAll().stream().map(transportUnitMapper :: toDTO).toList();
    }


    // create a transport unit

    public TransportUnitDTO createTransportUnit(TransportUnitDTO transportUnitDTO) {
    
        User driver = userRepository.findById(transportUnitDTO.getDriverId())
        .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + transportUnitDTO.getDriverId()));

       Fleet fleet = fleetRepository.findById(transportUnitDTO.getFleetId())
        .orElseThrow(() -> new EntityNotFoundException("Fleet not found with id: " + transportUnitDTO.getFleetId()));
        
        TransportUnit transportUnitToSave = transportUnitMapper.toEntity(transportUnitDTO); 

        transportUnitToSave.setDriver(driver);  
        transportUnitToSave.setFleet(fleet);  

        TransportUnit savedTransportUnit = transportUnitRepository.save(transportUnitToSave);     

        return  transportUnitMapper.toDTO(savedTransportUnit);
    } 

    // update a transport unit
    public TransportUnitDTO editTransportUnit(Long id, TransportUnitDTO transportUnitDTO) {
        
        TransportUnit transportUnitToUpdate = transportUnitRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Transport unit not found with id: " + id));

        
        if (transportUnitDTO.getDriverId() != null) {
            User driver = userRepository.findById(transportUnitDTO.getDriverId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + transportUnitDTO.getDriverId()));
            transportUnitToUpdate.setDriver(driver);
        }

        if (transportUnitDTO.getFleetId() != null) {
            Fleet fleet = fleetRepository.findById(transportUnitDTO.getFleetId())
                .orElseThrow(() -> new EntityNotFoundException("Fleet not found with id: " + transportUnitDTO.getFleetId()));
            transportUnitToUpdate.setFleet(fleet);
        }

        if (transportUnitDTO.getLicence() != null) {
            transportUnitToUpdate.setLicence(transportUnitDTO.getLicence());
        }
        if (transportUnitDTO.getModel() != null) {
            transportUnitToUpdate.setModel(transportUnitDTO.getModel());
        }
        if (transportUnitDTO.isActive() != transportUnitToUpdate.isActive()) {
            transportUnitToUpdate.setActive(transportUnitDTO.isActive());
        }

        TransportUnit updatedTransportUnit = transportUnitRepository.save(transportUnitToUpdate);

        return transportUnitMapper.toDTO(updatedTransportUnit);
    }

}

