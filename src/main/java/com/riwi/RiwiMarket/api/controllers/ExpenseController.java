package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IExpenseController;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Expense")
@AllArgsConstructor
@Tag(name = "Expense")
public class ExpenseController implements IExpenseController {

    @Autowired
    IExpenseService expenseService;

    @Override
    @PostMapping
    public ResponseEntity<ExpenseCompleteResponse> create(@Validated @RequestBody ExpenseRequest request) {



        return ResponseEntity.ok(this.expenseService.create(request));
    }

    @Override
    public ResponseEntity<ExpenseCompleteResponse> read(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<ExpenseCompleteResponse> update(ExpenseRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }
}
