package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IRefundController;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/Refund")
@Tag(name = "Refund Controller")
@AllArgsConstructor
public class RefundController implements IRefundController {
    @Autowired
    private final IRefundService refundService;

    @Override
    @PostMapping
    public ResponseEntity<RefundResponse> create(@Validated @RequestBody RefundRequest request) {

        return ResponseEntity.ok(this.refundService.create(request));

    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<RefundResponse> read(Long aLong) {
        return null;
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

    @Override
    public ResponseEntity<RefundResponse> update(RefundRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

}
