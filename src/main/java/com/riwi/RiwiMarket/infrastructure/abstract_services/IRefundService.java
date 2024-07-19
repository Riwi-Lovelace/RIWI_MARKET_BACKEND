package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.requests.RefundRequestGetAll;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import org.springframework.data.domain.Page;
import java.time.LocalDate;


public interface IRefundService extends GenericService<RefundRequest, RefundResponse, Long>{

    // Page<RefundResponse> getAll(int page, int size,Method method,Reason reason,LocalDate date,LocalDate dateEnd);
    Page<RefundResponse> getAll1(RefundRequestGetAll request);
}
