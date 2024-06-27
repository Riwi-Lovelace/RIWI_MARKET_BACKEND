package com.riwi.RiwiMarket.api.dtos.responses;

import java.util.List;

import com.riwi.RiwiMarket.domain.entities.Product;

import io.swagger.v3.oas.annotations.media.Schema;

public class BrandResponse
{
    @Schema(description = "Brand Id", example = "1")
    private Long id;

    @Schema(description = "Brand Name", example = "Nike")
    private String name;

    @Schema(description = "Brand Status", example = "Active || Inactive")
    private Boolean status;

    //private List<Product> products;
}
