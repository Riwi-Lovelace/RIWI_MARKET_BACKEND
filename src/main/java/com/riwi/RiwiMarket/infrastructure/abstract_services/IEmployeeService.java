package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CustomerResponse;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.util.enums.SortCustomer;
import com.riwi.RiwiMarket.util.enums.SortEmployee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService extends GenericService<EmployeeRequest, EmployeeResponse,Long>{
    public Page<EmployeeResponse> getAll(int size, int page, SortEmployee sortEmployee);
    public final String FIELD_SORT = "name";

    public List<EmployeeResponse> getAllNoPage();
}
