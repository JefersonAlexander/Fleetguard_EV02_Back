package com.microservice.fleetLocation.service;
import com.microservice.fleetLocation.entity.Fleet;
import com.microservice.fleetLocation.entity.TransportUnit;
import com.microservice.fleetLocation.entity.User;
import  com.microservice.fleetLocation.mapper.TransportUnitMapper;
import com.microservice.fleetLocation.repository.FleetRepository;
import  com.microservice.fleetLocation.repository.TransportUnitRepository;
import com.microservice.fleetLocation.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;




@Service
public class TransportUnitService {
    
    private final TransportUnitRepository transportUnitRepository; 
    private final TransportUnitMapper  transportUnitMapper;
    private final UserRepository userRepository;
    private final FleetRepository fleetRepository;
    
    
    @Autowired
    public TransportUnitService(TransportUnitRepository transportUnitRepository, 
                                 TransportUnitMapper transportUnitMapper,
                                 UserRepository userRepository,
                                 FleetRepository fleetRepository) {
        this.transportUnitRepository = transportUnitRepository;
        this.transportUnitMapper = transportUnitMapper;
        this.userRepository = userRepository;
        this.fleetRepository = fleetRepository;
     
    }
    
    public List<TransportUnitDTO> getAllTransportUnits() {
    return transportUnitRepository.findAllByDeletedFalse().stream().map(transportUnitMapper::toDTO).toList();
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
            throw new UnsupportedOperationException("The licence plate cannot be modified. It must remain the same.");
        }

        User driver = userRepository.findById(transportUnitDTO.getDriverId())
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + transportUnitDTO.getDriverId()));
        transportUnitToUpdate.setDriver(driver); 

       
        Fleet fleet = fleetRepository.findById(transportUnitDTO.getFleetId())
            .orElseThrow(() -> new EntityNotFoundException("Fleet not found with id: " + transportUnitDTO.getFleetId()));
        transportUnitToUpdate.setFleet(fleet);

        transportUnitToUpdate.setModel(transportUnitDTO.getModel());
        transportUnitToUpdate.setActive(transportUnitDTO.getActive());
        transportUnitToUpdate.setLicencePlate(transportUnitDTO.getLicencePlate());

        TransportUnit updatedTransportUnit = transportUnitRepository.save(transportUnitToUpdate);

        return transportUnitMapper.toDTO(updatedTransportUnit);
    }


    
    @Transactional
    public TransportUnitDTO logicallyDeleteTransportUnit(Long id) {
        
        TransportUnit transportUnitToUpdate = transportUnitRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Transport unit not found with id: " + id));

        transportUnitToUpdate.setDeleted(true);

        TransportUnit updatedTransportUnit = transportUnitRepository.save(transportUnitToUpdate);

        return transportUnitMapper.toDTO(updatedTransportUnit);
    }
}

