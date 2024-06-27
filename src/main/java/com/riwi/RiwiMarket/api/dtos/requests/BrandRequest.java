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
@Schema(description = "Request DTO for Brand entity")
public class BrandRequest 
{

    //en el request no se pide el id porque es generado de manera automatica en la entidad
    /*@NotNull
    @Schema(description = "Brand Id", example = "1")
    private Long id;*/

    @NotBlank(message = "category name is required")
    @Size(max = 50)
    @Schema(description = "Brand Name", example = "Nike")
    private String name;

    @NotNull
    @Schema(description = "Brand Status", example = "True || False")
    private Boolean status;

}
