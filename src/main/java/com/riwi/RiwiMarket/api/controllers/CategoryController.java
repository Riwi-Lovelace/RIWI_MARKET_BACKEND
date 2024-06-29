package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.dtos.requests.CategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CategoryResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/category")
@AllArgsConstructor
public class CategoryController implements GenericController<CategoryRequest, CategoryResponse,Long> {
    @Autowired
    private final ICategoryService categoryService;

    @Override
    @PostMapping
    @Operation(
            summary = "Create Category",
            description = "Fill in the required fields to create a new category."
    )
    public ResponseEntity<CategoryResponse> create(@Validated @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(this.categoryService.create(request));
    }


    @Operation(summary = "Get all categories", description = "Returns a paginated list of categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.categoryService.getAll(page - 1, size));
    }


    @Override
    @Operation(summary = "Get category by ID", description = "Returns a category based on ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.read(id));
    }


    @Override
    public ResponseEntity<CategoryResponse> update(CategoryRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }
}
