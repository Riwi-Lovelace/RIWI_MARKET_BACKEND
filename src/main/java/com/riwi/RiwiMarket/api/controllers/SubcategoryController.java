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
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISubcategory;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/subcategory")
@AllArgsConstructor
public class SubcategoryController implements GenericController<SubcategoryRequest, SubcategoryResponse, Long>{
    @Autowired
    private final ISubcategory subcategoryService;
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
    @PatchMapping("/{id}/name")
    public ResponseEntity<SubcategoryResponse> patchName(@Validated @RequestBody SubCategoryPatchRequest request, @PathVariable Long id) {
        SubcategoryResponse subCategoryPatchRequest = this.subcategoryService.patchName(id, request);
        return ResponseEntity.ok(subCategoryPatchRequest);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<SubcategoryResponse> patchStatus(@Validated @RequestBody SubCategoryPatchRequest request, @PathVariable Long id) {
        SubcategoryResponse subCategoryPatchRequest = this.subcategoryService.patchStatus(request, id);
        return ResponseEntity.ok(subCategoryPatchRequest);
    }
    

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
