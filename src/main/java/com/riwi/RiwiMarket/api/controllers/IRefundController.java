package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRefundController extends GenericController<RefundRequest, RefundResponse, Long>{

    ResponseEntity<List<RefundResponse>> getAll();

    ResponseEntity<List<RefundResponse>> getByMethod();

    ResponseEntity<List<RefundResponse>> getByReason();
}
