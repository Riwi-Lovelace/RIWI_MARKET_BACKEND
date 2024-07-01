package com.riwi.RiwiMarket.api.dtos.responses;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response DTO for Brand entity")
public class BrandResponse
{
    @Schema(description = "Brand Id", example = "1")
    private Long id;

    @Schema(description = "Brand Name", example = "Nike")
    private String name;

    @Schema(description = "Brand Status", example = "Active || Inactive")
    private Boolean status;

}
