package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;

import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.util.enums.MethodRefund;
import com.riwi.RiwiMarket.util.enums.ReasonRefund;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IRefundService extends GenericService<RefundRequest, RefundResponse, Long>{

    Page<RefundResponse> getAll(int page, int size);

    List<Refund> findByMethod(MethodRefund method);

    List<Refund> findByReason(ReasonRefund reason);
}
