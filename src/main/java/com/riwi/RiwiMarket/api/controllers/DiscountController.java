package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IDiscountService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/discount")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Endpoints Discount")
public class DiscountController implements GenericController<DiscountRequest,DiscountResponse,Long> {

    @Autowired
    private final IDiscountService service;





    @PostMapping
    @Override
    public ResponseEntity<DiscountResponse> create(@Validated @RequestBody DiscountRequest request) {
       return  ResponseEntity.ok(this.service.create(request));
    }

    @Override
    public ResponseEntity read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public ResponseEntity update(DiscountRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
