package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {
    private Long id;
    private Integer quantity;
    private BigDecimal weight;
}
