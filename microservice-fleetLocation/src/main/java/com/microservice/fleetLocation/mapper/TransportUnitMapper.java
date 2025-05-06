package com.microservice.fleetLocation.mapper;

import org.mapstruct.Mapper;
import com.microservice.fleetLocation.entity.TransportUnit;
import com.microservice.fleetLocation.DTO.TransportUnitDTO;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransportUnitMapper {
    //TransportUnitMapper INSTANCE = mappers.getMapper(TransportUnitMapper.class);
    TransportUnitDTO toDTO(TransportUnit transportUnit);
    TransportUnit toEntity(TransportUnitDTO transportUnitDTO);  
}
