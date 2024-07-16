package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IRefundController;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import java.util.List;

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

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<RefundResponse> read(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<RefundResponse>> getAll() {
        return null;
    }

    @GetMapping(path = "/{method}")
    @Override
    public ResponseEntity<List<RefundResponse>> getByMethod() {
        return null;
    }

    @GetMapping(path = "/{reason}")
    @Override
    public ResponseEntity<List<RefundResponse>> getByReason() {
        return null;
    }

    @Override
    public ResponseEntity<List<RefundResponse>> getByDate() {
        return null;
    }


    @GetMapping
    @Operation(summary = "Advance List of All refunds", description = "Refunds a paginated list of all refunds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of refunds"),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<Page<RefundResponse>> findAll(

            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String method,
            @RequestParam(defaultValue = "") String reason,
            @RequestParam(defaultValue = "yyyy-mm-dd") String date
    ){
        LocalDateTime dateTime = null
        try {
            if (!date.isEmpty()) {
                LocalDateTime dateTime = LocalDateTime.parse(date);
            }

            Page<RefundResponse> refunds = refundService.findByMethodContainingAndReasonContainingAndDateContaining(page -1, size, method, reason, dateTime);

            return ResponseEntity.ok(refunds);
        } catch (DateTimeParseException e){
            return ResponseEntity.badRequest().body(null);
        }


    }

    @Override
    public ResponseEntity<RefundResponse> update(RefundRequest request, Long aLong) {
        return null;
    }


    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

}
