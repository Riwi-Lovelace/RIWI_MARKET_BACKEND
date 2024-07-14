package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IStoreController;
import com.riwi.RiwiMarket.api.dtos.requests.StoreRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStoreService;
import com.riwi.RiwiMarket.util.enums.SortType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/store")
@AllArgsConstructor
@Tag(name = "Store")
public class StoreController implements IStoreController {

    @Autowired
    private final IStoreService storeService;

    @Override
/*    @PostMapping
    @Operation(
            summary = "Create Storage",
            description = "Fill in the required fields to create a new storage."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Storage retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })*/
    public ResponseEntity<StoreResponse> create(@Validated @RequestBody StoreRequest request) {
        return null; /*ResponseEntity.ok(this.storeService.create(request))*/
    }

    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Get Store information by Id.",
            description = "This endpoint return the information of the Store and basic information of its Employees."
    )
    public ResponseEntity<StoreResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.storeService.read(id));
    }

    @Override
    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Update a store", description = "update any store selected by id")
    public ResponseEntity<StoreResponse> update(@Validated @RequestBody StoreRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.storeService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @Override
    @GetMapping
    @Operation(summary = "Get all the stores information",
            description = "Get a list with all the stores and their information.")
    public ResponseEntity<Page<StoreResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.storeService.getAll(page - 1, size, sortType));
    }
}
