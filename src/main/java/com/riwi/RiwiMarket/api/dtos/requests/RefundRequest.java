package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.domain.entities.Item;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
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
    private Method method;
    @NotNull(message = "The reason of refund can't be null")
    private Reason reason;
    @NotNull(message = "The item id in Refund is required")
    private Item itemId;
}
