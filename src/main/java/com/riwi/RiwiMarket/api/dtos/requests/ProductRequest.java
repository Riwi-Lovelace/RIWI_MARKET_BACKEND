package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "product name is required")
    private String name;

    @DecimalMin(value = "0",message = "TAX cannot be less than 0")
    @DecimalMax(value = "100",message = "TAX could not be greater than 100")
    @NotNull(message = "TAX is required")
    private BigDecimal iva;

    @NotNull(message = "status is required")
    private Boolean status;

    @NotBlank(message = "Url imagen name is required")
    private String urlImg;

    @NotNull(message = "subcategory name is required")
    private Long subcategoryID;

    @DecimalMin(value = "0",message = "weight cannot be less than 0")
    private BigDecimal weightThreshold;

    @Min(value = 0,message = "the quantity cannot be less than 0")
    private Integer quantityThreshold;
}