package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Subcategory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubcategoryMapper extends GenericMapper<Subcategory, SubcategoryRequest, SubcategoryResponse>{
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    Subcategory  toUserEntity(SubcategoryRequest request);
}
