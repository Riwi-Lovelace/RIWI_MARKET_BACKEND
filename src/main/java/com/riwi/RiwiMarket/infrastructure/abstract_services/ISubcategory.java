package com.riwi.RiwiMarket.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;

public interface ISubcategory extends GenericService<SubcategoryRequest, SubcategoryResponse, Long>{
    SubcategoryResponse patchName(Long id, SubCategoryPatchRequest request);
    SubcategoryResponse patchStatus(SubCategoryPatchRequest request, Long id);
    Page<SubcategoryResponse> getAll(int page, int size);
}
