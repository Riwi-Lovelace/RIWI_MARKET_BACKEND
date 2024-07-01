package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.TypePocket;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PocketResponse {
    private BigDecimal amount;
    private TypePocket type;
    private String description;
    //private List<PaymentExpenseResponse> expenseResponses;
}
