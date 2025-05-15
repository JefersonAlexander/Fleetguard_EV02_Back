package com.microservice.authentication.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO {
    private Long permissionId;
    private String permissionName;
    private String description;
    private List<RoleDTO> roles;
}
