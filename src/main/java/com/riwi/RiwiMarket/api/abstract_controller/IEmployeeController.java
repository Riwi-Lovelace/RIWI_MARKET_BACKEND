package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IEmployeeController extends GenericController<EmployeeRequest, EmployeeResponse, Long>{

    ResponseEntity<Page<EmployeeResponse>> getAll();
}
