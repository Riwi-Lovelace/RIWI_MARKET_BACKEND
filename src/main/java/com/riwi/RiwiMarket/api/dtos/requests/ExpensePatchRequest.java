package com.riwi.RiwiMarket.api.dtos.requests;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensePatchRequest extends ExpenseBasicRequest{

    private List<PaymentExpenseRequest> paymentExpenseId;
    private Long supplierId;
    private Long employeeId;

}
