package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.util.enums.GeneralSort;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStockService extends GenericService<StockRequest, StockResponse, Long> {

    public final String FIELD_BY_SORT_STOCK = "batch";
    Page<StockResponse> getAll(String productName, String categoryName, int size, int page, GeneralSort generalSort);

    StockResponse updateStock(StockUpdateRequest request, Long id);

}
