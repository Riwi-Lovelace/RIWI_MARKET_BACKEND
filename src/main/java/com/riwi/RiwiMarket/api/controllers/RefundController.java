package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IRefundController;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;

import java.util.List;

@RestController
@RequestMapping(path = "/Refund")
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

    @Override
    public ResponseEntity<RefundResponse> update(RefundRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

}
