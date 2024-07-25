package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CashMachineToEmployeeResponse {
    private Long id;
    private LocalDateTime date;
    private BigDecimal initialBalance;
    private BigDecimal balance;
}
