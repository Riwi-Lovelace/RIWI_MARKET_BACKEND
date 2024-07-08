package com.riwi.RiwiMarket.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IDiscountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@SuppressWarnings("rawtypes")
@RestController
@AllArgsConstructor
@RequestMapping("/discount")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Endpoints Discount")
public class DiscountController implements GenericController<DiscountRequest, DiscountResponse, Long> {

    @Autowired
    private final IDiscountService service;

    @Operation(
        summary = "create a new discount",
        description = "You must send, description, amount, startDiscount, endDiscount and status."
    )
    @PostMapping
    @Override
    public ResponseEntity<DiscountResponse> create(@Validated @RequestBody DiscountRequest request) {
        return ResponseEntity.ok(this.service.create(request));
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

    /****************************/
    @Operation(
        summary = "List all discounts with pagination",
        description = "You must send the page and size to receive all corresponding clients."
    )
    @GetMapping
    public ResponseEntity<Page<DiscountResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.service.getAll(page - 1, size));
    }

    @ApiResponse(
        responseCode = "400",
        description = "The id is not valid",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @Operation(
        summary = "Show discounts by ID",
        description = "You must send the id of the reservation you want to see"
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscountResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @Operation(
        summary = " discount list by description",
        description = "list the discounts according to the description entered."
    )
    @GetMapping(path = "/description/{description}")
    public ResponseEntity<List<DiscountResponse>> findByDescriptionContaining(
            @PathVariable String description) {
        return ResponseEntity.ok(this.service.findByDescriptionContaining(description));
    }

    @Operation(
        summary = " discount list by amount",
        description = "list the discounts according to the amount entered."
    )
    @GetMapping(path = "/amount/{amount}")
    public ResponseEntity<List<DiscountResponse>> findByAmount(
            @PathVariable double amount) {
        return ResponseEntity.ok(this.service.findByAmount(amount));
    }
    @PatchMapping(path = "/{id}/disable")
        public ResponseEntity<DiscountResponse> disableStudent(@PathVariable Long id) {

                this.service.delete(id);
                return ResponseEntity.noContent().build();
        }
}
