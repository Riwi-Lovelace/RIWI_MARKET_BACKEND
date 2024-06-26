package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryResponse {
    private Long id;
    private String name;
    private Boolean status;
}
