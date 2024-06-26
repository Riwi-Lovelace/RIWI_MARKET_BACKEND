package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class SupplierRequestUpdate extends SupplierRequest {

    @NotNull(message = "Status is required")
    private Boolean status;

}