package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.CustomerRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CustomerResponse;

public interface ICustomerService extends GenericService<CustomerRequest, CustomerResponse, Long>{
    CustomerResponse getById(Long id);
}
