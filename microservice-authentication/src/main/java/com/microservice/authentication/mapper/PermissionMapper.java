package com.microservice.authentication.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import com.microservice.authentication.DTO.PermissionDTO;
import com.microservice.authentication.entity.Permission;

@Repository
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    PermissionDTO toDTO (Permission permission);
    Permission toEntity (PermissionDTO permissionDTO);
}
