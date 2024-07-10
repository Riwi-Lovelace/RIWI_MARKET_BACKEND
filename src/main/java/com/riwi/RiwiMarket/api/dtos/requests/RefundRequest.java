package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.domain.entities.Item;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import lombok.*;

import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefundRequest {

    @NotNull(message = "The method of refund can't be null")
    private Method method;
    @NotNull(message = "The reason of refund can't be null")
    private Reason reason;
    @NotNull(message = "The item id in Refund is required")
    private Integer quantity;
    @NotNull(message = "The item id in Refund is required")
    private Long itemId;
}
