package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.api.dtos.requests.PaymentExpenseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExpenseCompleteResponse extends ExpenseBasicResponse {

    private List<PaymentExpenseRequest> paymentExpense;
    private SupplierResponse supplier;
    private EmployeeResponse employee;
}
