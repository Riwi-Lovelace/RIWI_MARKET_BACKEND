package com.riwi.RiwiMarket.api.controller;

import com.riwi.RiwiMarket.api.dto.request.BrandRequest;
import com.riwi.RiwiMarket.api.dto.response.BrandResponse;
import com.riwi.RiwiMarket.infraestructure.abstrac_service.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/brands")
@AllArgsConstructor
public class BrandController {
    @Autowired
    private final IBrandService brandService;

    @PostMapping
    public ResponseEntity<BrandResponse> insert(
            @Validated @RequestBody BrandRequest brand){
        return ResponseEntity.ok(this.brandService.create(brand));
    }
}
