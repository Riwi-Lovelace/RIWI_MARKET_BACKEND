package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ReturnRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ReturnResponse;

import com.riwi.RiwiMarket.domain.entities.Return;
import com.riwi.RiwiMarket.util.enums.MethodReturn;
import com.riwi.RiwiMarket.util.enums.ReasonReturn;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IReturnService extends GenericService<ReturnRequest, ReturnResponse, Long>{

    Page<ReturnResponse> getAll(int page, int size);

    List<Return> findByMethod(MethodReturn method);

    List<Return> findByReason(ReasonReturn reason);
}
