package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseBasicResponse;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import com.riwi.RiwiMarket.domain.repositories.ExpenseRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ExpenseMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService implements IExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseMapper expenseMapper;


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
    public ExpenseBasicResponse patchExpense(Long id, ExpenseBasicResponse expenseBasicResponse) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
        expenseMapper.patchBasicResponse( expenseBasicResponse, expense);
        Expense updatedExpense = expenseRepository.save(expense);
        return expenseMapper.entityToBasicResponse(updatedExpense);

    }

}
