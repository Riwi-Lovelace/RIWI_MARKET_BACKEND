package com.riwi.RiwiMarket.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryPatchRequest {
    private String name;
    private Boolean status;
    // private Long categoryId;
}
