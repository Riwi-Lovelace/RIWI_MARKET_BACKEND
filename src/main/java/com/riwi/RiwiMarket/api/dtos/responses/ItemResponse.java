package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Sale;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
   // private Sale billID;
    private Long id;
    private ProductResponse product;
    private Integer quantity;
    private BigDecimal weight;
    private BigDecimal totalPrice;
    private Boolean status;


}
