package com.microservice.fleetLocation.service;
import com.microservice.fleetLocation.entity.Fleet;
import com.microservice.fleetLocation.entity.TransportUnit;
import com.microservice.fleetLocation.entity.User;
import com.microservice.fleetLocation.entity.TransportUnitStatus;
import  com.microservice.fleetLocation.mapper.TransportUnitMapper;
import com.microservice.fleetLocation.repository.FleetRepository;
import  com.microservice.fleetLocation.repository.TransportUnitRepository;
import com.microservice.fleetLocation.repository.TransportUnitStatusRepository;
import com.microservice.fleetLocation.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import com.microservice.fleetLocation.DTO.TransportUnitDetailDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;




@Service
public class TransportUnitService {
    
    @Autowired
    private final TransportUnitRepository transportUnitRepository; 
    private final TransportUnitMapper  transportUnitMapper;
    private final UserRepository userRepository;
    private final FleetRepository fleetRepository;
    private final TransportUnitStatusRepository transportUnitStatusRepository;
    

    public TransportUnitService(TransportUnitRepository transportUnitRepository, 
                                 TransportUnitMapper transportUnitMapper,
                                 UserRepository userRepository,
                                 FleetRepository fleetRepository,
                                 TransportUnitStatusRepository transportUnitStatusRepository) {
        this.transportUnitRepository = transportUnitRepository;
        this.transportUnitMapper = transportUnitMapper;
        this.userRepository = userRepository;
        this.fleetRepository = fleetRepository;
        this.transportUnitStatusRepository = transportUnitStatusRepository;
    }

    // get a transport units
    public List<TransportUnitDetailDTO> getAllTransportUnits() {
    return transportUnitRepository.findAllByDeletedFalse().stream().map(transportUnitMapper::toDetailDTO).toList();
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


        if (!Objects.equals(transportUnitDTO.getLicencePlate(), transportUnitToUpdate.getLicencePlate())) {
            throw new UnsupportedOperationException("The licence plate cannot be modified.");
        }

        User driver = userRepository.findById(transportUnitDTO.getDriverId())
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + transportUnitDTO.getDriverId()));
        transportUnitToUpdate.setDriver(driver); 

       
        Fleet fleet = fleetRepository.findById(transportUnitDTO.getFleetId())
            .orElseThrow(() -> new EntityNotFoundException("Fleet not found with id: " + transportUnitDTO.getFleetId()));
        transportUnitToUpdate.setFleet(fleet);

        TransportUnitStatus status = transportUnitStatusRepository.findById(transportUnitDTO.getStatusId())
            .orElseThrow(() -> new EntityNotFoundException("Status not found with id: " + transportUnitDTO.getStatusId()));
        transportUnitToUpdate.setStatus(status);


        transportUnitToUpdate.setModel(transportUnitDTO.getModel());    
        transportUnitToUpdate.setCapacity(transportUnitDTO.getCapacity());
        transportUnitToUpdate.setLicencePlate(transportUnitDTO.getLicencePlate());

        TransportUnit updatedTransportUnit = transportUnitRepository.save(transportUnitToUpdate);

        return transportUnitMapper.toDTO(updatedTransportUnit);
    }


    
     // Delete logical a transport unit 
    public TransportUnitDTO logicallyDeleteTransportUnit(Long id) {
        
        TransportUnit transportUnitToUpdate = transportUnitRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Transport unit not found with id: " + id));

        transportUnitToUpdate.setDeleted(true);

        TransportUnit updatedTransportUnit = transportUnitRepository.save(transportUnitToUpdate);

        return transportUnitMapper.toDTO(updatedTransportUnit);
    }
}

