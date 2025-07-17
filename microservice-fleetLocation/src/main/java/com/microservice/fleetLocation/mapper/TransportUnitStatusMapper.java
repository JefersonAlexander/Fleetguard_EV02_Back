package com.microservice.fleetLocation.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.microservice.fleetLocation.DTO.TransportUnitStatusDTO;
import com.microservice.fleetLocation.entity.TransportUnitStatus;

@Mapper(componentModel = "spring")
public interface TransportUnitStatusMapper {
    TransportUnitStatusMapper INSTANCE = Mappers.getMapper(TransportUnitStatusMapper.class);
    TransportUnitStatusDTO toDTO(TransportUnitStatus transportUnitState);
    TransportUnitStatus toEntity(TransportUnitStatusDTO transportUnitStateDTO);
}
