package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.util.enums.TypePocket;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PocketRequest {
    @NotNull(message = "amount is required")
    @DecimalMin("0.00")
    private BigDecimal amount;
    @NotNull(message = "type is required")
    private TypePocket type;
    private String description;
}
