package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.requests.BrandRequest;
import com.riwi.RiwiMarket.api.dtos.responses.BrandResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IBrandService;
import com.riwi.RiwiMarket.infrastructure.services.BrandService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Brands")
@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController implements GenericController<BrandRequest, BrandResponse, Long>
{
    @Autowired
    private final IBrandService brandService;

    @Operation(summary = "Get all Brands", description = "Get all brands with pagination")
    @GetMapping
    public ResponseEntity<Page<BrandResponse>> searchOrListBrands(
            @RequestParam(value = "name", defaultValue = "", required = false) String name,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size)
    {
        Pageable pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(this.brandService.search(name, pageable));
    }

    @Override
    public ResponseEntity<BrandResponse> create(BrandRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @GetMapping("/{brand_id}")
    @Operation(summary = "Get a brand by brand_id", description = "Send the brand brand_id to get brand details")
    @Override
    public ResponseEntity<BrandResponse> read(Long brand_id) {
        return ResponseEntity.ok(this.brandService.read(brand_id));
    }

    @Override
    public ResponseEntity<BrandResponse> update(BrandRequest request, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
