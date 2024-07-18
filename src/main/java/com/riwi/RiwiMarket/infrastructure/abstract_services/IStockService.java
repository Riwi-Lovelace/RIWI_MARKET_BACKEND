package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.util.enums.GeneralSort;

import java.util.List;

public interface IStockService extends GenericService<StockRequest, StockResponse, Long> {
    List<StockResponse> getAll(String productName, String categoryName, int size, int page, GeneralSort generalSort);

    StockResponse updateQuantity(StockQuantityUpdateRequest request, Long id);

    StockResponse updateWeight(StockWeightUpdateRequest request, Long id);
}
