package com.microservice.fleetLocation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.microservice.fleetLocation.entity.Fleet;
import com.microservice.fleetLocation.entity.TransportUnit;
import com.microservice.fleetLocation.entity.User;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransportUnitMapper {
    TransportUnitMapper INSTANCE = Mappers.getMapper(TransportUnitMapper.class);

    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "fleet.id", target = "fleetId")
    TransportUnitDTO toDTO(TransportUnit transportUnit);

    @Mapping(source = "driverId", target = "driver", qualifiedByName = "mapDriver")
    @Mapping(source = "fleetId", target = "fleet", qualifiedByName = "mapFleet")
    TransportUnit toEntity(TransportUnitDTO transportUnitDTO);  

    @Named("mapDriver")
    default User mapDriver(Long driverId) {
        User user = new User();
        user.setId(driverId);
        return user;
    }

    @Named("mapFleet")
        default Fleet mapFleet(Long fleetId) {
            Fleet fleet = new Fleet();
            fleet.setId(fleetId);
            return fleet;
        }
    
}

