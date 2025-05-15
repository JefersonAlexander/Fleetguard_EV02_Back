package com.microservice.fleetLocation.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.microservice.fleetLocation.entity.User;
import com.microservice.fleetLocation.DTO.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO userDTO);
}
