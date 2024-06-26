package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.CategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper extends  GenericMapper<CategoryRequest, CategoryResponse, Category> {
    Category toCategoryEntity(CategoryRequest userRequest);

    CategoryResponse toCategoryResponse(Category userEntity);

}
