package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IStockController;
import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<StockResponse>> getAll() {
        return null;
    }


    @Override
    @Operation(summary = "Update Stock", description = "Update the Quantity or the Weight of the Stock by giving the Id as a parameter. User can only update one field of the product. If want to update the quantity, he must just changed that field and the other one will keep in 0 or null. If want to change the Weight, it will be the same, just change the Weight field and quantity must keep in 0 or null. Negatives values are not allowed.")
    @PatchMapping("/{id}")
    public StockResponse updateStock(@Validated @RequestBody StockUpdateRequest request, @PathVariable Long id) {
        return this.stockService.updateStock(request, id);
    }

    @Override
    public ResponseEntity<StockResponse> updateWeight(StockWeightUpdateRequest request, Long id) {
        return null;
    }
}
