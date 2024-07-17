package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductToBatchResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal iva;
    private String description;
    private Boolean status;
}
