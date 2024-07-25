package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.util.enums.Status;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExpenseBasicRequest {

    @NotNull(message = "Amount is required")
    @DecimalMin("0.00")
    private BigDecimal amount;

    private LocalDate specifDate;

    @NotBlank(message = "Description is required")
    @Size(min = 0, max = 100)
    private String description;

    @NotNull(message = "Paid status is required")
    private Status paidStatus;
}
