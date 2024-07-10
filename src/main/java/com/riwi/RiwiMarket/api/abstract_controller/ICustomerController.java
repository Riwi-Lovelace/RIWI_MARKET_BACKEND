package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.CustomerRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CustomerResponse;

public interface ICustomerController extends GenericController<CustomerRequest, CustomerResponse, Long>{
}
