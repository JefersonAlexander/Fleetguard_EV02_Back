package com.microservice.authentication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservice.authentication.DTO.PermissionDTO;
import com.microservice.authentication.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    PermissionDTO toDTO (Permission permission);
    Permission toEntity (PermissionDTO permissionDTO);
}
