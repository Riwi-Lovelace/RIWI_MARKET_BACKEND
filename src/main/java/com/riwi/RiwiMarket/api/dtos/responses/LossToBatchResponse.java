package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.Reason;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LossToBatchResponse {
    private Long id;
    private Integer quantity;
    private LocalDateTime date;
    private BigDecimal weight;
    private Reason reason;
}
