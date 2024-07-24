package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.domain.entities.Discount;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiscountMapper extends GenericMapper<DiscountRequest, DiscountResponse, Discount> {

    DiscountMapper mapper = Mappers.getMapper(DiscountMapper.class);

    @Mappings({
        @Mapping(target = "id", ignore = true)
    })
   
    Discount requestToEntity(DiscountRequest request);

    @InheritInverseConfiguration
    DiscountResponse entityToResponse(Discount discount);
}
