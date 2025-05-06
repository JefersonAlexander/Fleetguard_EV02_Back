package com.microservice.fleetLocation.service;
import com.microservice.fleetLocation.entity.Fleet;
import com.microservice.fleetLocation.mapper.FleetMapper;
import com.microservice.fleetLocation.repository.FleetRepository;
import com.microservice.fleetLocation.DTO.FleetDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FleetService {
    
    private final FleetRepository fleetRepository;
    private final FleetMapper fleetMapper;  

    @Autowired
    public FleetService(FleetRepository fleetRepository, FleetMapper fleetMapper) {
        this.fleetRepository = fleetRepository;
        this.fleetMapper = fleetMapper;
    }

    public List<FleetDTO> getAllFleets() {
 
        return fleetRepository.findAll().stream()
                .map(fleetMapper::toDTO).toList();
    } 


    // Create a new fleet
    
    public FleetDTO createFleet(FleetDTO fleetDTO) {
        Fleet fleet = fleetMapper.toEntity(fleetDTO); 
        Fleet savedFleet = fleetRepository.save(fleet);
        return fleetMapper.toDTO(savedFleet); 
    }
}
