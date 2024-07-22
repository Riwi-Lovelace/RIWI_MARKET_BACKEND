package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseToEmployeeResponse {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;
}
