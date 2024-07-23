package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IStockController;
import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStockService;
import com.riwi.RiwiMarket.util.enums.GeneralSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @GetMapping
    @Override
    @Operation(
            summary = "Get information of the stock",
            description = "You can get all the stock of the store when you don't specify product Name and category Name. When you specify one parameter for searching you get the products that match or you even can specify two parameter and get the stock that match product Name and category Name. This get is paginate."
    )
    public ResponseEntity<Page<StockResponse>> getAll(@RequestParam(required = false, value = "") String productName,
                                                      @RequestParam(required = false, value = "") String categoryName,
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
