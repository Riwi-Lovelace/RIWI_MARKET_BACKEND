package com.riwi.RiwiMarket.api.controllers;


import java.util.Objects;

import com.riwi.RiwiMarket.api.abstract_controller.ICustomerController;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.CustomerRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CustomerResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ICustomerService;
import com.riwi.RiwiMarket.util.enums.SortCustomer;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/customers")
@AllArgsConstructor
public class CustomerController implements ICustomerController{

    private final ICustomerService customerService;

    @Override
    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Validated @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(this.customerService.create(request));
    }

    @Override  //This method for me is equals getById
    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.read(id));
    }

    @Override
    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomerResponse> update(@Validated @RequestBody CustomerRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.update(id, request));
    }

    @Override // Customer cannot be deleted
    public ResponseEntity<Void> delete(Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(@RequestParam(defaultValue = "5") int size, 
                                                        @RequestParam(defaultValue = "1") int page, 
                                                        @RequestHeader(required = false) SortCustomer sortCustomer) {
        if (Objects.isNull(sortCustomer)) sortCustomer = SortCustomer.NONE;
        return ResponseEntity.ok(this.customerService.getAll(size, page - 1, sortCustomer));
    }

    @PostMapping(path = "/{userDefault}")
    public ResponseEntity<String> createUserDefault(@PathVariable String userDefault){
        return ResponseEntity.ok(this.customerService.createUserDefault(userDefault));
    }
}
