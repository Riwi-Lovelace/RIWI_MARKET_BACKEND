package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService implements IExpenseService {


    @Override
    public ExpenseCompleteResponse create(ExpenseRequest request) {
        return null;
    }

    @Override
    public ExpenseCompleteResponse read(Long aLong) {
        return null;
    }

    @Override
    public ExpenseCompleteResponse update(Long aLong, ExpenseRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
