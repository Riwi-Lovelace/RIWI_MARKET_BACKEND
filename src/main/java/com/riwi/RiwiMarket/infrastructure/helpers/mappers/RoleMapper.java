package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.RiwiMarket.api.dtos.requests.RoleRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RoleResponse;
import com.riwi.RiwiMarket.domain.entities.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper extends GenericMapper<RoleRequest, RoleResponse, Role> {
    
}
