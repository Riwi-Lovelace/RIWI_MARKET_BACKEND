package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.domain.entities.Subcategory;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private Integer quantityThreshold;
    private BigDecimal weightThreshold;
    private BigDecimal iva;
    private Boolean status;
    private SubcategoryResponse subcategory;
    private String urlImg;

}
