package com.riwi.RiwiMarket.api.dtos.requests;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DiscountRequest {
    @NotBlank(message = "Discount description cannot be blank")
    @Size(max = 100, message = "description must be less than 100 characters")
    private String description;    
    @NotNull(message = "Discount percentage is required")
    @Min(value = 0, message = "Discount percentage must be between 0 and 100")
    @Max(value = 100, message = "Discount percentage must be between 0 and 100")
    private Integer amount;    
    @NotNull(message = "Start date for discount is required")
    private LocalDate startDiscount;    
    private LocalDate endDiscount;
}