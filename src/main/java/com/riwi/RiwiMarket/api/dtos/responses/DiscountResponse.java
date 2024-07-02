package com.riwi.RiwiMarket.api.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class DiscountResponse {
    private Long id;
    private String description;
    private Double amount;
    private LocalDate startDiscount;
    private LocalDate endDiscount;
    private Boolean status;
}
