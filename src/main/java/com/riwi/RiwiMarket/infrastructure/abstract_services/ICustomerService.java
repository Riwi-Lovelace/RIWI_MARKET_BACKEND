package com.riwi.RiwiMarket.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.RiwiMarket.api.dtos.requests.CustomerRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CustomerResponse;
import com.riwi.RiwiMarket.util.enums.SortCustomer;

public interface ICustomerService extends GenericService<CustomerRequest, CustomerResponse, Long>{
    public Page<CustomerResponse> getAll(int size, int page, SortCustomer sortCustomer);
    public final String FIELD_SORT = "name";
    String createUserDefault (String userDefault);
}
