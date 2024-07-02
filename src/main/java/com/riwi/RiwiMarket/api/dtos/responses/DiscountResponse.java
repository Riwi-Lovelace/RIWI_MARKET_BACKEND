package com.riwi.RiwiMarket.api.dtos.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Integer amount;
    private LocalDateTime startDiscount;
    private LocalDateTime endDiscount;
    private Boolean status;
}
