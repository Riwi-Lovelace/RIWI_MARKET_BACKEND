package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ReturnRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ReturnResponse;
import com.riwi.RiwiMarket.domain.entities.Return;
import com.riwi.RiwiMarket.domain.repositories.ReturnRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IReturnService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ReturnMapper;
import com.riwi.RiwiMarket.util.enums.MethodReturn;
import com.riwi.RiwiMarket.util.enums.ReasonReturn;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
@AllArgsConstructor
public class ReturnService implements IReturnService {

    @Autowired
    ReturnMapper returnMapper;

    @Autowired
    ReturnRepository returnRepository;

    @Autowired
    SupportService<Return> supportService;


    @Override
    public ReturnResponse create(ReturnRequest request) {
        return null;
    }

    @Override
    public Page<ReturnResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public List<Return> findByMethod(MethodReturn method) {
        return null;
    }

    @Override
    public List<Return> findByReason(ReasonReturn reason) {
        return null;
    }

    @Override
    public ReturnResponse read(Long aLong) {
        return null;
    }

    @Override
    public ReturnResponse update(Long aLong, ReturnRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
