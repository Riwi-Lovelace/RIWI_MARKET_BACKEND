package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IRefundController;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
<<<<<<< HEAD

import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> 934abf820dd77b06e2058fbc2c8d3303f78d838f
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.infrastructure.services.RefundService;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

=======
>>>>>>> 934abf820dd77b06e2058fbc2c8d3303f78d838f
import java.util.List;

@RestController
@RequestMapping(path = "/Refund")
@Tag(name="Refund Controller")
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

    private final RefundService refundService;

    @GetMapping("/all")
    public ResponseEntity<Page<RefundResponse>> getAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RefundResponse> refunds = refundService.getAll(pageable);
        return ResponseEntity.ok(refunds);
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
