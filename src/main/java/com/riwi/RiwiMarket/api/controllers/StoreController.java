package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IStoreController;
import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StoreRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Store")
@AllArgsConstructor
@Tag(name = "Store")
public class StoreController implements IStoreController {

    @Autowired
    private final IStoreService storeService;

    @Override
    public ResponseEntity<StoreResponse> create(StoreRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<StoreResponse> read(Long id) {
        return null;
    }

    @Override
    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Update a store",description = "update any store selected by id")
    public ResponseEntity<StoreResponse> update(@Validated @RequestBody StoreRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.storeService.update(id,request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<StoreResponse>> getAll() {
        return null;
    }
}
