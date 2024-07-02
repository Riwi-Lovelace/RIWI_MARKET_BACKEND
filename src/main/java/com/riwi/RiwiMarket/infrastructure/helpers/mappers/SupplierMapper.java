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


    @Mappings({
        @Mapping(target = "id", ignore= true),
        @Mapping(target = "status", ignore= true)
    })
    Supplier toUserEntity(SupplierRequest userRequest);

    @InheritInverseConfiguration
    SupplierRequest toSupplierRequest(Supplier user);

    SupplierResponse entityToResponse(Supplier supplier);


}
