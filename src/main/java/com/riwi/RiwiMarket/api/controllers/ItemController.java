package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.ItemRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;
import com.riwi.RiwiMarket.domain.entities.Item;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/items")
@Tag(name= "item")
@AllArgsConstructor
public class ItemController implements GenericController<ItemRequest, ItemResponse, Item> {
    @Autowired
    private final IItemService itemService;

    @Override
    @PostMapping
    @Operation(
            summary = "Create Item",
            description = "Fill in the required fields to create a new Item."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "item retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    }
    )

    public ResponseEntity<ItemResponse> create(@Validated @RequestBody ItemRequest request) {
        return ResponseEntity.ok(this.itemService.create(request));
    }

    @Override
    public ResponseEntity<ItemResponse> read(Item item) {
        return null;
    }

    @Override
    public ResponseEntity<ItemResponse> update(ItemRequest request, Item item) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Item item) {
        return null;
    }
}
