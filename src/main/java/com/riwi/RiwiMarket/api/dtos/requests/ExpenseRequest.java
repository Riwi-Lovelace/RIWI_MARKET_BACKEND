package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.domain.entities.PaymentExpense;
import com.riwi.RiwiMarket.util.enums.Status;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {
    @NotNull(message = "Amount is required")
    @DecimalMin("0.00")
    private BigDecimal amount;

    private LocalDate specifDate;

    @NotBlank(message = "Description is required")
    @Size(min = 0, max = 100)
    private String description;

    @NotNull(message = "Paid status is required")
    private Status paidStatus;

    private List<PaymentExpenseRequest> paymentExpenseId;
    private Long supplierId;
    private Long employeeId;

}
