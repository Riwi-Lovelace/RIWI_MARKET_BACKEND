package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private Long id;
    private Integer quantity;
    private BigDecimal weight;
    private BigDecimal totalPrice;
    private Boolean status;
    private Double discount;

}
