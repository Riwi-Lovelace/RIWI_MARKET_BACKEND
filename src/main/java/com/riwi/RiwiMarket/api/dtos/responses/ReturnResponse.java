package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.MethodReturn;
import com.riwi.RiwiMarket.util.enums.ReasonReturn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResponse {

    private Long id;
    private MethodReturn method;
    private ReasonReturn reason;
    private LocalDateTime date;

}
