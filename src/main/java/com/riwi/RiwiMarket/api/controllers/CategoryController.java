package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.dtos.requests.CategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CategoryResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public ResponseEntity<CategoryResponse> read(Long aLong) {
        return null;
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
