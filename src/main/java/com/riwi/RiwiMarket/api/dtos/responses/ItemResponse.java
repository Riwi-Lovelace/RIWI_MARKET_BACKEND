package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.domain.entities.Product;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private Long billID;
    private String productId;
    private Integer quantity;
    private BigDecimal weight;
    private BigDecimal totalPrice;
    private Boolean status;


}
