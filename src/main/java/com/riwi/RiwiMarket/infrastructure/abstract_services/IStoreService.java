package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.StoreRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.util.enums.SortType;
import org.springframework.data.domain.Page;

public interface IStoreService extends GenericService<StoreRequest, StoreResponse, Long>{
    Page<StoreResponse> getAll(int page, int size, SortType sortStore);
}
