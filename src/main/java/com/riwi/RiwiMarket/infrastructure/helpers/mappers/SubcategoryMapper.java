package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import java.util.Map;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubcategoryMapper extends GenericMapper<Subcategory, SubcategoryRequest, SubcategoryResponse>{
    
    SubcategoryMapper mapper = Mappers.getMapper(SubcategoryMapper.class);

    @Mapping(target = "id", ignore = true)
    Subcategory toUserEntity(SubcategoryRequest request);

    @Mapping(target = "id", ignore = true)
    Subcategory requestPatchtoUserEntity(SubCategoryPatchRequest request);

    @InheritInverseConfiguration
    SubcategoryResponse toUserResponse(Subcategory userEntity);

    // @Mapping(target = "id", ignore = true)
    // default void patchUpdate(@MappingTarget Subcategory subcategory, Map<String, Object> fields){

    //     if (fields.containsKey("name")) {
    //         subcategory.setName((String) fields.get("name"));
    //     }
    //     if (fields.containsKey("status")) {
    //        Object status = fields.get("status");
    //        if (status instanceof Boolean) {
    //             subcategory.setStatus((Boolean) status);
    //        } 
    //        else if(status instanceof String){
    //             subcategory.setStatus(Boolean.parseBoolean((String) status));
    //        }
    //        else{
    //         throw new BadRequestException("The Status is invalid");
    //        }
    //     }
    // }

    @Mapping(target = "id", ignore = true)
    void updateSubcategoryFromDto (SubcategoryRequest request, @MappingTarget Subcategory subcategory);
}
