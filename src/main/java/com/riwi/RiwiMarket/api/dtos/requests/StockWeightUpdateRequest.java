package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockWeightUpdateRequest {
    @NotNull(message = "id is required")
    private Long id;
    @NotNull(message = "weight is required")
    private BigDecimal weight;
}
