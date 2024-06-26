package com.riwi.RiwiMarket.api.dto.request;

import com.riwi.RiwiMarket.util.enums.StatusBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {
    @NotBlank(message = "category name is required")
    @Size(min=1,max=50)
    private String name;
    @NotNull(message = "status brand is required")
    private StatusBrand status;
}
