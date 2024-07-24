package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseGetRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpensePatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import org.springframework.data.domain.Page;

public interface IExpenseService extends GenericService<ExpenseRequest, ExpenseCompleteResponse , Long>{

    Page<ExpenseGetRequest> getAll(ExpenseGetRequest request);
    
}
