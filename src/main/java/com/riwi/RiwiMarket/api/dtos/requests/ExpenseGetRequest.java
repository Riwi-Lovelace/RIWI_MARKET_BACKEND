package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.util.enums.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseGetRequest {
    private Integer page;
    private Integer size;
    private Long id;
    private String description;
    private Status paidStatus;
    private LocalDate start;
    private LocalDate end;
    private BigDecimal min;
    private BigDecimal max;
    private Long supplierId;
    private Long employeeId;
}
