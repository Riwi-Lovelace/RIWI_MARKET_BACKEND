package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/supplier")
@AllArgsConstructor
public class SupplierController implements GenericController{

    @Autowired
    private final ISupplierService supplierService;

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
    
}
