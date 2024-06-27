package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.util.enums.MethodReturn;
import com.riwi.RiwiMarket.util.enums.ReasonReturn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRequest {

    @NotNull(message = "The method of return can't be null")
    private MethodReturn method;
    @NotNull(message = "The reason of return can't be null")
    private ReasonReturn reason;
}
