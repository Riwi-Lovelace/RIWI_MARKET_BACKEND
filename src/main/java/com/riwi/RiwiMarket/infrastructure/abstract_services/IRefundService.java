package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;

import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface IRefundService extends GenericService<RefundRequest, RefundResponse, Long>{

    Page<RefundResponse> getAll(int page, int size);

    Page<RefundResponse> findByMethodContainingAndReasonContainingAndDateContaining(int page, int size, String method, String reason, LocalDateTime date);
}
