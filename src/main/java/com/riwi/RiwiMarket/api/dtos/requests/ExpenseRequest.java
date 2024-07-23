package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.domain.entities.PaymentExpense;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;
    private List<PaymentExpenseRequest> paymentExpenseId;
    private Long supplier;
    private Long employee;

}
