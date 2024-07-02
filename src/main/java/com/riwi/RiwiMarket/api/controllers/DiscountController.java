package com.riwi.RiwiMarket.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IDiscountService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@SuppressWarnings("rawtypes")
@RestController
@AllArgsConstructor
@RequestMapping("/discount")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Endpoints Discount")
public class DiscountController implements GenericController {

    @Autowired
    private final IDiscountService service;

    @Override
    public ResponseEntity create(Object request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity read(Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public ResponseEntity update(Object request, Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity delete(Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /****************************/
    @GetMapping
    public ResponseEntity<Page<DiscountResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size){
            return ResponseEntity.ok(this.service.getAll(page -1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscountResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.getById(id));
    }

    @GetMapping(path = "/description/{description}")
    public ResponseEntity<List<DiscountResponse>> findByDescriptionContaining(
        @PathVariable String description){
        return ResponseEntity.ok(this.service.findByDescriptionContaining(description));
    }
    
    @GetMapping(path = "/amount/{amount}")
    public ResponseEntity<List<DiscountResponse>> findByAmount (
        @PathVariable double amount){
            return ResponseEntity.ok(this.service.findByAmount(amount));
    }
    


}
