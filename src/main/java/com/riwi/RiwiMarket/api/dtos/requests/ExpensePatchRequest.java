package com.riwi.RiwiMarket.api.dtos.requests;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExpensePatchRequest extends ExpenseBasicRequest{

    private List<PaymentExpenseRequest> paymentExpenseId;
    private Long supplierId;
    private Long employeeId;

}
