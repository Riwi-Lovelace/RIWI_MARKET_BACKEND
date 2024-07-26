package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface IRefundController extends GenericController<RefundRequest, RefundResponse, Long>{

    ResponseEntity<Page<RefundResponse>> getAll(int page, int size,Method method, Reason reason,LocalDate date, LocalDate dateEnd);
}
