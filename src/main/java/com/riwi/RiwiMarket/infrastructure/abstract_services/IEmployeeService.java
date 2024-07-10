package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import org.springframework.data.domain.Page;

public interface IEmployeeService extends GenericService<EmployeeRequest, EmployeeResponse,Long>{
    Page<EmployeeResponse> getAll(int page, int size);
}
