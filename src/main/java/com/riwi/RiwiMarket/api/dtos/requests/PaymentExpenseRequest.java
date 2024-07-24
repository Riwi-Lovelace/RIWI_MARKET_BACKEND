package com.riwi.RiwiMarket.api.dtos.requests;

import java.math.BigDecimal;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentExpenseRequest {
    private Long pocketId;
    private BigDecimal amount;

}
