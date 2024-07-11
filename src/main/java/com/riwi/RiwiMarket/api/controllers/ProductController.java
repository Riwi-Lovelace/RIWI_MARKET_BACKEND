package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductController implements GenericController<ProductRequest, ProductResponse,Long> {
    @Autowired
    private final IProductService productService;

    @Override
    @PostMapping
    @Operation(
            summary = "Create Product",
            description = "Fill in the required fields to create a new Product."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<ProductResponse> create(@Validated ProductRequest request) {
        return ResponseEntity.ok(this.productService.create(request));
    }

    @Override
    public ResponseEntity<ProductResponse> read(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> update(ProductRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

    @PutMapping("/active/{id}")
    @Operation(
            summary = "Unarchive Product",
            description = "Change the status of the product to active."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product unarchived successfully or already active"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Map<String, String>> unarchiveProduct(@PathVariable Long id) {
        Map<String, String> response = productService.unarchiveProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/inactive/{id}")
    @Operation(
            summary = "Archive Product",
            description = "Change the status of the product to inactive."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product archived successfully or already archived"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Map<String, String>> archiveProduct(@PathVariable Long id) {
        Map<String, String> response = productService.archiveProduct(id);
        return ResponseEntity.ok(response);
    }

}
