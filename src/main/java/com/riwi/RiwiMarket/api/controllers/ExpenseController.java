package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IExpenseController;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseGetRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;


import com.riwi.RiwiMarket.infrastructure.services.ExpenseService;
import com.riwi.RiwiMarket.util.enums.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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




    @GetMapping
    @Operation(
            summary = "Get information of expense",
            description = "You can get all expense of store if u don't put anything, but u can also obtain by whatever u want"
    )
    @Override
    public ResponseEntity<Page<ExpenseCompleteResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false, value = "") Long id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Status paidStatus,
            @RequestParam(required = false, value = "") LocalDate start,
            @RequestParam(required = false,value = "") LocalDate end,
            @RequestParam(required = false) BigDecimal min,
            @RequestParam(required = false) BigDecimal max,
            @RequestParam(required = false) Long supplierId,
            @RequestParam(required = false) Long employeeId) {

        ExpenseGetRequest request = ExpenseGetRequest.builder()
                .page(page-1)
                .size(size)
                .id(id)
                .description(description)
                .paidStatus(paidStatus)
                .start(start)
                .end(end)
                .min(min)
                .max(max)
                .supplierId(supplierId)
                .employeeId(employeeId)
                .build();


        return ResponseEntity.ok(this.expenseService.getAll(request)); //In honor of Kristopher Rivas & contributors
    }

}
