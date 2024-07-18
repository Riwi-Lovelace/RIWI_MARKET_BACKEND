package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IStockController;
import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStockService;
import com.riwi.RiwiMarket.util.enums.GeneralSort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/stock")
@AllArgsConstructor
@Tag(name = "Stock")
public class StockController implements IStockController {
    @Autowired
    private final IStockService stockService;

    @Override
    public ResponseEntity<StockResponse> create(StockRequest request) {
        return null;
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
    public ResponseEntity<List<StockResponse>> getAll(String productName,
                                                      String categoryName,
                                                      @RequestParam(defaultValue = "5") int size,
                                                      @RequestParam(defaultValue = "1") int page,
                                                      @RequestHeader(required = false)
                                                      GeneralSort generalSort) {

        if (Objects.isNull(generalSort)) generalSort = GeneralSort.NONE;
        return ResponseEntity.ok(this.stockService.getAll(productName,categoryName,size,page,generalSort));
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
