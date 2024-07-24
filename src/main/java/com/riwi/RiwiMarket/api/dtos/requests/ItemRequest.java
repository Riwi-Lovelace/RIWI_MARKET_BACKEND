package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Refund;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    private Integer quantity;

    private BigDecimal weight;

    @NotNull(message = "The total price is required")
    @DecimalMin("0.00")
    private BigDecimal totalPrice;

    @NotNull(message = "The status is required")
    private Boolean status;

    private Double discount;


    //This item should be replaced in the future.

}
