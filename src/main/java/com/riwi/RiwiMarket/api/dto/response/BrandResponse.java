package com.riwi.RiwiMarket.api.dto.response;

import com.riwi.RiwiMarket.util.enums.StatusBrand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {
    private Long id;
    private String name;
    private StatusBrand status;
}
