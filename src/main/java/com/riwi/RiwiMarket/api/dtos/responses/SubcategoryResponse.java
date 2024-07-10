package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryResponse {
    private Long id;
    private String name;
    private Boolean status;
    private CategoryResponse category;
}
