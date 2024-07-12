package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    //@NotBlank(message = "subcategory name is required")
    //private Long subcategory;
}