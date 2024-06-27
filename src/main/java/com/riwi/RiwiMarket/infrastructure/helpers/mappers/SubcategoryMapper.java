package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Subcategory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubcategoryMapper extends GenericMapper<Subcategory, SubcategoryRequest, SubcategoryResponse>{
    
    SubcategoryMapper mapper = Mappers.getMapper(SubcategoryMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    Subcategory  toUserEntity(SubcategoryRequest request);
    
    @InheritInverseConfiguration
    SubcategoryResponse toUserResponse(Subcategory userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name",source = "name", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "status", source = "status", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    // @Mapping(target = "categoryId", ignore = true)
    void patchSubcategoryFromDto (SubCategoryPatchRequest request, @MappingTarget Subcategory subcategory);

    @Mapping(target = "id", ignore = true)
    void updateSubcategoryFromDto (SubcategoryRequest request, @MappingTarget Subcategory subcategory);
}
