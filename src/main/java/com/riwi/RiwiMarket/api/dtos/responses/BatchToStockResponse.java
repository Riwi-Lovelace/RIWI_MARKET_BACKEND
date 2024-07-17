package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchToStockResponse {
    private Long id;
    private LocalDateTime expiration;
    private Integer quantity;
    private BigDecimal weight;
    private BigDecimal purchasePrice;
    private LocalDateTime entryDate;
}
