package com.riwi.RiwiMarket.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path = "/Refund")
@AllArgsConstructor
public class RefundController implements IRefundController{

    @Override
    public ResponseEntity<RefundResponse> create(RefundRequest request) {
        return null;
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
    public ResponseEntity<RefundResponse> update(RefundRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

}
