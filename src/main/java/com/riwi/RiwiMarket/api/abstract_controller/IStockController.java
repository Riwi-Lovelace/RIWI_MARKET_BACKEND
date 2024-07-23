package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.util.enums.GeneralSort;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStockController extends GenericController<StockRequest, StockResponse,Long> {
    ResponseEntity<Page<StockResponse>> getAll(String productName, String categoryName, int size, int page, GeneralSort generalSort);

    ResponseEntity<StockResponse> updateQuantity(StockQuantityUpdateRequest request, Long id);

    ResponseEntity<StockResponse> updateWeight(StockWeightUpdateRequest request, Long id);
}
