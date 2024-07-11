package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.ProductBrandRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    public ResponseEntity<ProductResponse> create(@Validated @RequestBody ProductRequest request) {
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
    
    @PutMapping("/brand/{id}")
    @Operation(
            summary = "Add Brand to Product",
            description = "Add an existing brand to an existing product by providing their IDs."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brand successfully added to the product"),
            @ApiResponse(responseCode = "400", description = "Invalid product or brand ID"),
            @ApiResponse(responseCode = "404", description = "Product or brand not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Map<String, String>> addBrandToProduct(@Validated @RequestBody ProductBrandRequest request, @PathVariable Long id) {
        Long brandId = request.getBrandId();
        Long productId = id;


        productService.addBrandToProduct(productId, brandId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Brand successfully added to the product");
        return ResponseEntity.ok(response);
    }

}
