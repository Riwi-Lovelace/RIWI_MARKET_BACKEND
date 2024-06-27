package com.riwi.RiwiMarket.api.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class BrandRequest 
{
    @NotNull
    @Schema(description = "Brand Id", example = "1")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Brand Name", example = "Nike")
    private String name;

    @NotNull
    @Schema(description = "Brand Status", example = "Active || Inactive")
    private Boolean status;

}
