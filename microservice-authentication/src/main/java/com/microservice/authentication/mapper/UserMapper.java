package com.microservice.authentication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservice.authentication.DTO.UserDTO;
import com.microservice.authentication.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO (User user);
    User toEntity (UserDTO  userDTO);
}
