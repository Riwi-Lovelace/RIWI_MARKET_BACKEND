package com.riwi.RiwiMarket.api.dtos.requests;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrandRequest {
    private Long productId;
    private Long brandId;
}
