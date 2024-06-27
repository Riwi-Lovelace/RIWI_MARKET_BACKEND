package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.MethodRefund;
import com.riwi.RiwiMarket.util.enums.ReasonRefund;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefundResponse {

    private Long id;
    private MethodRefund method;
    private ReasonRefund reason;
    private LocalDateTime date;

}
