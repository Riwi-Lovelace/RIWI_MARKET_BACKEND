package com.riwi.RiwiMarket.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.api.abstract_controller.IRefundController;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;

import lombok.AllArgsConstructor;
import java.time.LocalDate;


@RestController
@RequestMapping(path = "/refund")
@Tag(name="Refund Controller")
@AllArgsConstructor
public class RefundController implements IRefundController {
    @Autowired
    private final IRefundService refundService;

    @Override
    @Operation(summary = "Create refund", description = "Add new refund.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Create new refund."),
            @ApiResponse(responseCode = "400", description = "Bad request. This occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Refunds with the incorrect request")
    })
    @PostMapping
    public ResponseEntity<RefundResponse> create(@Validated @RequestBody RefundRequest request) {

        return ResponseEntity.ok(this.refundService.create(request));


    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<RefundResponse> read(Long aLong) {
        return ResponseEntity.ok(this.refundService.read(aLong));
    }



    @GetMapping
    @Override
    public ResponseEntity<Page<RefundResponse>> getAll(@RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(required = false, value="") Method method,
    @RequestParam(required = false ) Reason reason,
    @RequestParam(required = false,value="") LocalDate star,
    @RequestParam(required = false,value="") LocalDate end){
        
        return ResponseEntity.ok(this.refundService.getAll(page-1, size, method, reason, star, end));
    }


    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }


    @Override
    public ResponseEntity<RefundResponse> update(RefundRequest request, Long aLong) {
        return null;
    }


}
