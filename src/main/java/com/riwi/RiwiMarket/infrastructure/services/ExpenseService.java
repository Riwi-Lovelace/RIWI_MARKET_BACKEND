package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.requests.PaymentExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.requests.ExpenseGetRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import com.riwi.RiwiMarket.domain.entities.PaymentExpense;
import com.riwi.RiwiMarket.domain.entities.Pocket;
import com.riwi.RiwiMarket.domain.repositories.EmployeeRepository;
import com.riwi.RiwiMarket.domain.repositories.ExpenseRepository;
import com.riwi.RiwiMarket.domain.repositories.PaymentExpenseRepository;
import com.riwi.RiwiMarket.domain.repositories.PocketRepository;
import com.riwi.RiwiMarket.domain.repositories.SupplierRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IExpenseService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ExpenseMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.riwi.RiwiMarket.util.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService implements IExpenseService {
    @Autowired
    private final ExpenseRepository expenseRepository;
    @Autowired
    private final ExpenseMapper expenseMapper;
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final SupplierRepository supplierRepository;
    @Autowired
    private final PocketRepository pocketRepository;
    @Autowired
    private final PaymentExpenseRepository paymentExpenseRepository;

    @Override
    public ExpenseCompleteResponse create(ExpenseRequest request) {
        Expense expense = this.expenseMapper.toEntity(request);
        Pocket pocket = new Pocket();
        expense.setEmployeeId(this.employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new BadRequestException("ID NOT FOUND")));
        expense.setSupplierId(this.supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new BadRequestException("ID NOT FOUND")));
                List<PaymentExpense> paymentExpenseList = new ArrayList<>();
        System.out.println(2);
        expenseRepository.save(expense);
        BigDecimal subtotal= request.getAmount();
        BigDecimal subtract= new BigDecimal(0.0);
        for (PaymentExpenseRequest paymentExpenseRequest : request.getPaymentExpenseId()) {

            System.out.println(paymentExpenseRequest.getPocketId());
            PaymentExpense paymentExpense = new PaymentExpense();
             pocket = this.pocketRepository.findById(paymentExpenseRequest.getPocketId()).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
            subtract = request.getAmount().subtract(paymentExpenseRequest.getAmount());
            int total = subtract.compareTo(BigDecimal.ZERO);

            if (total > 0) {
                Status status = Status.valueOf("Pending");
                expense.setPaidStatus(status);
                System.out.println(1);

            } else if (total == 0) {
                Status status = Status.valueOf("Paid");
                expense.setPaidStatus(status);
                System.out.println(1);

            } else {
                Status status = Status.valueOf("Late");
                expense.setPaidStatus(status);
                System.out.println(1);
            }

           pocket.setAmount(pocket.getAmount().subtract(paymentExpenseRequest.getAmount()));
           request.setAmount(subtract);
            pocketRepository.save(pocket);
            paymentExpense.setPocketId(pocket);
            paymentExpense.setExpenseId(expense);
            paymentExpenseRepository.save(paymentExpense);
            paymentExpenseList.add(paymentExpense);
            subtotal=subtract;

        }

        pocketRepository.save(pocket);
        expense.setAmount(subtotal);
        expense.setPaymentExpensesId(paymentExpenseList);
        expense.setDate(LocalDateTime.now());
        return this.expenseMapper.toResponse(this.expenseRepository.save(expense));
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

    @Override
    public Page<ExpenseCompleteResponse> getAll(ExpenseGetRequest request) {

        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());

        if (request.getId() == null && request.getMin() == null && request.getMax() == null && request.getDescription() == null && request.getStart() == null && request.getEnd() == null && request.getPaidStatus() == null && request.getSupplierId() == null && request.getEmployeeId() == null){
            Page<Expense> expensePage = this.expenseRepository.findAll(pageRequest);

            Page<Expense> expenses = this.expenseRepository.findAll(pageRequest);
            List<ExpenseCompleteResponse> expenseCompleteResponses = this.expenseMapper.listEntities(expensePage.getContent());
            return new PageImpl<>(expenseCompleteResponses, pageRequest, expensePage.getTotalElements());
        }else{
            Page<Expense> expensePage = this.expenseRepository.getAll(pageRequest,request.getId(),request.getMin(),request.getMax(),request.getDescription(),request.getStart(),request.getEnd(),request.getPaidStatus(),request.getSupplierId(),request.getEmployeeId());
            List<ExpenseCompleteResponse> expenseCompleteResponse = this.expenseMapper.listEntities(expensePage.getContent());
            return new PageImpl<>(expenseCompleteResponse, pageRequest,expensePage.getTotalElements());
        }
    }

}
