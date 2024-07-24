package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.ExpensePatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;

public interface IExpenseController extends GenericController<ExpenseRequest, ExpenseCompleteResponse, Long>{
}
