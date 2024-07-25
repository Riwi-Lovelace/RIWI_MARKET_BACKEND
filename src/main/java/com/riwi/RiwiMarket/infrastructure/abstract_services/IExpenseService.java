package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseGetRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import com.riwi.RiwiMarket.util.enums.Status;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IExpenseService extends GenericService<ExpenseRequest, ExpenseCompleteResponse , Long>{

    Page<ExpenseCompleteResponse> getAll(ExpenseGetRequest request);



}
