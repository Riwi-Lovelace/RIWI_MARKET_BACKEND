package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseGetRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpensePatchRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import com.riwi.RiwiMarket.domain.repositories.ExpenseRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ExpenseMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService implements IExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    ExpenseMapper expenseMapper;

    @Override
    public ExpenseCompleteResponse create(ExpensePatchRequest request) {
        return null;
    }

    @Override
    public ExpenseCompleteResponse read(Long aLong) {
        return null;
    }

    @Override
    public ExpenseCompleteResponse update(Long aLong, ExpensePatchRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<ExpenseGetRequest> getAll(ExpenseGetRequest request) {

        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());

        if (request.getId() == null && request.getMin() == null && request.getMax() == null && request.getDescription() == null && request.getStart() == null && request.getEnd() == null && request.getPaidStatus() == null && request.getSupplierId() == null && request.getEmployeeId() == null){
            Page<Expense> expensePage = this.expenseRepository.findAll(pageRequest);

            Page<Expense> expenses = this.expenseRepository.findAll(pageRequest);
            List<ExpenseCompleteResponse> expenseCompleteResponses = this.expenseMapper.listEntities(expensePage.getContent());
            return new PageImpl<>(expenseCompleteResponses, pageRequest, expensePage.getTotalElements());
        }else{

        }

    }
}
