package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
@Tag(name= "Product")
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

    public ResponseEntity<ProductResponse> create(ProductRequest request) {
        return ResponseEntity.ok(this.productService.create(request));
    }

    /****** Fine by id ****/
    @ApiResponse(
        responseCode = "400", description = "ID not found"
    )
    @Operation(
        
        summary = "see product by id",
        description = "Write the ID of the product you are looking for."
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.read(id));
    }

    @Override
    public ResponseEntity<ProductResponse> update(ProductRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

    /******* Fine by name *****/
    @ApiResponse(
        responseCode = "400", description = "Name not found"
    )
    @Operation(
        summary = "see product by name",
        description = "Write the name of the product you are looking for."
    )
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<ProductResponse>> findByName(
        @PathVariable String name) {
        return ResponseEntity.ok(this.productService.findByName(name));
    }

    /*
    @GetMapping(path = "/subCategory/{subCategory}")
    public ResponseEntity<List<ProductResponse>> findBySubcategoryId(
        @PathVariable Long id) {
        return ResponseEntity.ok(this.productService.findBySubcategoryId(id));
    }*/

    /******* List all products *****/
    @Operation(
        summary = "see all products",
        description = "list of all products."
    )
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size
    ){
        return ResponseEntity.ok(this.productService.getAll(page -1, size));
    }

    
}
