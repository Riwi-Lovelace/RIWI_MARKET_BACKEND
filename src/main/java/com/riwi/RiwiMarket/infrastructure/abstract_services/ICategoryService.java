package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.CategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CategoryResponse;
import org.springframework.data.domain.Page;

public interface ICategoryService extends GenericService<CategoryRequest, CategoryResponse,Long>{
    Page<CategoryResponse> getAll(int page, int size);

}
