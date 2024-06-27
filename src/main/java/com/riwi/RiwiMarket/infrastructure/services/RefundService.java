package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.domain.repositories.RefundRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.RefundMapper;
import com.riwi.RiwiMarket.util.enums.MethodRefund;
import com.riwi.RiwiMarket.util.enums.ReasonRefund;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
@AllArgsConstructor
public class RefundService implements IRefundService {

    @Autowired
    RefundMapper returnMapper;

    @Autowired
    RefundRepository refundRepository;

    @Autowired
    SupportService<Refund> supportService;


    @Override
    public RefundResponse create(RefundRequest request) {
        return null;
    }

    @Override
    public Page<RefundResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public List<Refund> findByMethod(MethodRefund method) {
        return null;
    }

    @Override
    public List<Refund> findByReason(ReasonRefund reason) {
        return null;
    }

    @Override
    public RefundResponse read(Long aLong) {
        return null;
    }

    @Override
    public RefundResponse update(Long aLong, RefundRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
