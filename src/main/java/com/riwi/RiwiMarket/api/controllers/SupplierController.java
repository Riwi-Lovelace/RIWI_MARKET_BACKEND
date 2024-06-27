package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.domain.entities.Supplier;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SupplierController {

        @Autowired
        private final ISupplierService SupplierService;


        //Method pach for active o disable this service
        @PatchMapping("/{id}/status")
        public ResponseEntity<Supplier> suplierUpdateStatus(@PathVariable Long id){
            SupplierService.disableSuplier(id);
        return ResponseEntity.noContent().build();
        }


    
}
