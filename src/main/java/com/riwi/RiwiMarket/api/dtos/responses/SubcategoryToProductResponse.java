package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryToProductResponse {
    private Long id;
    private String name;
    private Boolean status;
    private CategoryToSubcategoryResponse category;
}
