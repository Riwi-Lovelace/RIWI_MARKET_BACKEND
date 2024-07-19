package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentExpenseResponse {
    private Long id;
    private ExpenseBasicResponse expense;
    private PocketResponse pocket;
}
