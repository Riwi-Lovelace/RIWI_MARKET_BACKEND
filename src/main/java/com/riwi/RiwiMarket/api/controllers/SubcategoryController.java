package com.riwi.RiwiMarket.api.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/subcategory")
@AllArgsConstructor
public class SubcategoryController implements GenericController<SubcategoryRequest, SubcategoryResponse, Long>{
    
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
    public ResponseEntity<SubcategoryResponse> update(SubcategoryRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
