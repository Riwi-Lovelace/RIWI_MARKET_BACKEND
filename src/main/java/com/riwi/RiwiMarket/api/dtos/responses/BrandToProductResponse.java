package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandToProductResponse {
    private Long id;
    private Boolean status;
}
