package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.domain.entities.Discount;

@SuppressWarnings("rawtypes")
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public class DiscountMapper implements GenericMapper {
    @Mapping(target = "id",ignore = true)
    @Override
    public Discount toUserEntity(Object userRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUserEntity'");
    }

    @Override
    public DiscountResponse toUserResponse(Object userEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUserResponse'");
    }

}
