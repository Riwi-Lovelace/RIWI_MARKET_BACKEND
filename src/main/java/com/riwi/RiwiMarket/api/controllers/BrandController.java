package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.BrandRequest;
import com.riwi.RiwiMarket.api.dtos.responses.BrandResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IBrandService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @ApiResponse(
        responseCode = "200",
        description = "Successful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "when send word is invalid",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
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

    @ApiResponse(
            responseCode = "200",
            description = "Successfully created the brand",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = BrandResponse.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "incorrect request format in invalid request",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            }
    )

    @PostMapping
    @Operation(summary = "Create a new Brand", description = "Create a new brand with the specified name and status. Returns the created brand's details.")
    @Override
    public ResponseEntity<BrandResponse> create(
            @Validated @RequestBody BrandRequest request) {
        return ResponseEntity.ok(this.brandService.create(request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @ApiResponse(
        responseCode = "200",
        description = "Successful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = BrandResponse.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "when send id is invalid",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @GetMapping("/{brand_id}")
    @Operation(summary = "Get a brand by brand_id", description = "Send the brand brand_id to get brand details")
    @Override
    public ResponseEntity<BrandResponse> read(@PathVariable Long brand_id) {
        return ResponseEntity.ok(this.brandService.read(brand_id));
    }

    @Override
    public ResponseEntity<BrandResponse> update(BrandRequest request, Long id) {
        
        return null;
    }

}
