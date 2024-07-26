package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockUpdateRequest {
//    @NotNull(message = "quantity is required")
    private Integer quantity;

//    @NotNull(message = "weight is required")
    private BigDecimal weight;
}
