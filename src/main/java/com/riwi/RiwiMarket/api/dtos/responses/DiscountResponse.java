package com.riwi.RiwiMarket.api.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class DiscountResponse {
    private Long id;
    private String description;
    private Integer amount;
    private LocalDate start;
    private LocalDate end;
    private Boolean status;
}
