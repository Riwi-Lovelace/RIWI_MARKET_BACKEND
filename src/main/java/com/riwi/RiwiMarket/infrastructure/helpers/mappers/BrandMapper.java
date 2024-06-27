package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.RiwiMarket.api.dtos.requests.BrandRequest;
import com.riwi.RiwiMarket.api.dtos.responses.BrandResponse;
import com.riwi.RiwiMarket.domain.entities.Brand;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandMapper extends GenericMapper<BrandRequest, BrandResponse, Brand>
{
    @Override
    public Brand toEntity(BrandRequest brandRequest);

    @Override
    @InheritInverseConfiguration
    public BrandResponse toResponse(Brand brand);
}
