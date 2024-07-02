package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.domain.entities.Supplier;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SupplierMapper extends GenericMapper<SupplierRequest, SupplierResponse, Supplier>{

}
