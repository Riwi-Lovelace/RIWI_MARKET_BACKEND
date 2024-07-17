package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Subcategory;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubcategoryMapper extends GenericMapper<SubcategoryRequest, SubcategoryResponse, Subcategory> {

    @InheritInverseConfiguration
    SubcategoryResponse toSubcategoryResponse(Subcategory subcategory);

    default Page<SubcategoryResponse> subCategoryResponsePage(Page<Subcategory> subcategoryPage, int page, int size){
        List<SubcategoryResponse> subcategories = subcategoryPage
        .stream()
        .map(this::toSubcategoryResponse)
        .collect(Collectors.toList());

        Pageable pageable = PageRequest.of(page, size);

        return new PageImpl<>(subcategories, pageable, subcategoryPage.getTotalElements()); 
    }
}
