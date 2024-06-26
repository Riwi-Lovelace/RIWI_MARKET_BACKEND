package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.TypePocket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PocketResponse {
    private BigDecimal amount;
    private TypePocket type;
    private String description;
    //private List<PaymentExpenseResponse> expenseResponses;
}
