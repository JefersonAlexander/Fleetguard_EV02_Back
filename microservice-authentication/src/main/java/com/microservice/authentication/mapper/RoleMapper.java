package com.microservice.authentication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservice.authentication.DTO.RoleDTO;
import com.microservice.authentication.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDTO toDTO (Role role);
    Role toEntity (RoleDTO roleDTO);
}
