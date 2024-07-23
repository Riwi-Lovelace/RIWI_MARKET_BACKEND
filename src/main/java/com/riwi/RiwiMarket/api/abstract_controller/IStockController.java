package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStockController extends GenericController<StockRequest, StockResponse,Long> {
    ResponseEntity<List<StockResponse>> getAll();

    StockResponse updateStock(StockUpdateRequest request, Long id);

    ResponseEntity<StockResponse> updateWeight(StockWeightUpdateRequest request, Long id);
}
