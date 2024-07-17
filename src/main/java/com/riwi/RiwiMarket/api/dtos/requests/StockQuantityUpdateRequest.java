package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockQuantityUpdateRequest {
    @NotNull(message = "quantity is required")
    private Integer quantity;
}
