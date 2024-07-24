package com.riwi.RiwiMarket.api.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

import com.riwi.RiwiMarket.domain.entities.PaymentExpense;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExpenseCompleteResponse extends ExpenseBasicResponse {

    private List<PaymentExpenseResponse> paymentExpenseId;
    private SupplierResponse supplierId;
    private EmployeeBasicResponse employeeId;
}
