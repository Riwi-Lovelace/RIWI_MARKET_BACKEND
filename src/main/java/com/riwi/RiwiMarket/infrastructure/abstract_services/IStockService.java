package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;

import java.util.List;

public interface IStockService extends GenericService<StockRequest, StockResponse, Long> {
    List<StockResponse> getAll(String productName, String categoryName);

    StockResponse updateStock(StockUpdateRequest request, Long id);

}
