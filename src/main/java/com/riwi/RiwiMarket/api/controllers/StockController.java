package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IStockController;
import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
@AllArgsConstructor
@Tag(name = "Stock")
public class StockController implements IStockController {
    @Autowired
    private final IStockService stockService;

    @Override
    @Operation(summary = "Creat a stock", description = "Create a stock by sending the batch that will be associated")
    @PostMapping
    public ResponseEntity<StockResponse> create(@Validated @RequestBody StockRequest request) {

        return ResponseEntity.ok(this.stockService.create(request));

    }

    @Override
    public ResponseEntity<StockResponse> read(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<StockResponse> update(StockRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<StockResponse>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<StockResponse> updateQuantity(StockQuantityUpdateRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<StockResponse> updateWeight(StockWeightUpdateRequest request, Long id) {
        return null;
    }
}
