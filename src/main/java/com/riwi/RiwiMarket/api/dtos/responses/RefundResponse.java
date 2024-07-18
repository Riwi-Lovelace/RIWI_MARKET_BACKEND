package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefundResponse {

    private Long id;
    private Method method;
    private Reason reason;
    private LocalDate date;
    private Integer quantity;
    private ItemResponse itemId;

}
