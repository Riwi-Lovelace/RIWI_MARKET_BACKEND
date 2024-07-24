package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IExpenseController;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseBasicResponse;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Expense")
@AllArgsConstructor
@Tag(name = "Expense")
public class ExpenseController implements IExpenseController {

    @Autowired
    IExpenseService expenseService;

    @Override
    public ResponseEntity<ExpenseCompleteResponse> create(ExpenseRequest request) {
        return null;
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

    @PatchMapping("/{id}")
    public ResponseEntity<ExpenseBasicResponse> patchExpense(
            @PathVariable Long id,
            @RequestBody ExpenseBasicResponse expenseBasicResponse) {
        try {
            ExpenseBasicResponse updatedExpense = expenseService.patchExpense(id, expenseBasicResponse);
            return ResponseEntity.ok(updatedExpense);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
