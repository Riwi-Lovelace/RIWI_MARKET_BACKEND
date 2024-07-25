package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
   // @NotNull(message = "Invoice ID is required")
   // private Long billID;
    @NotNull(message = "Product ID is required")
    private Long productId;
    private Integer quantity;
    private BigDecimal weight;
}
