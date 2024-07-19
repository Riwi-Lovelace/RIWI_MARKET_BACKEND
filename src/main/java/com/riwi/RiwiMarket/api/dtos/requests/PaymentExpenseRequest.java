package com.riwi.RiwiMarket.api.dtos.requests;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentExpenseRequest {
    private Long pocketId;
}
