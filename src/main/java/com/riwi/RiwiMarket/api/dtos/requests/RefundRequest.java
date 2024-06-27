package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.util.enums.MethodRefund;
import com.riwi.RiwiMarket.util.enums.ReasonRefund;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefundRequest {

    @NotNull(message = "The method of refund can't be null")
    private MethodRefund method;
    @NotNull(message = "The reason of refund can't be null")
    private ReasonRefund reason;
}
