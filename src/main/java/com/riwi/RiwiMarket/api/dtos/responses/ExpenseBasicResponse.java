package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExpenseBasicResponse {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;
}
