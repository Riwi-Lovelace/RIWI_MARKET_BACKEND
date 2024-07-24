package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseBasicResponse;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;

public interface IExpenseService extends GenericService<ExpenseRequest, ExpenseCompleteResponse, Long>{

    ExpenseBasicResponse patchExpense(Long id, ExpenseBasicResponse expenseBasicResponse);
}
