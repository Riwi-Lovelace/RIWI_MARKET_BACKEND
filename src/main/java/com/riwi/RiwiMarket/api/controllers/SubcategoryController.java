package com.riwi.RiwiMarket.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.infrastructure.services.SubcategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/subcategory")
@AllArgsConstructor
public class SubcategoryController implements GenericController<SubcategoryRequest, SubcategoryResponse, Long>{
    @Autowired
    private final SubcategoryService subcategoryService;
    @Override
    public ResponseEntity<SubcategoryResponse> create(SubcategoryRequest request) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity<SubcategoryResponse> read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SubcategoryResponse> update(@Validated @RequestBody SubcategoryRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.subcategoryService.update(id, request));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<SubcategoryResponse> patch(@Validated @RequestBody SubCategoryPatchRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.subcategoryService.patch(id, request));
    }
    

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
