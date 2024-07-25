package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.util.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IExpenseController extends GenericController<ExpenseRequest, ExpenseCompleteResponse, Long>{

    ResponseEntity<Page<ExpenseCompleteResponse>> getAll(Integer page,
                                                         Integer size,
                                                         Long id,
                                                         String description,
                                                         Status paidStatus,
                                                         LocalDate start,
                                                         LocalDate end,
                                                         BigDecimal min,
                                                         BigDecimal max,
                                                         Long supplierId,
                                                         Long employeeId);
}
