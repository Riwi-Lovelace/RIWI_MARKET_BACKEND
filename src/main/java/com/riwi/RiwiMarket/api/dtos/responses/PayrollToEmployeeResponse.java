package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayrollToEmployeeResponse {
    private Long id;
    private LocalDateTime date;
    private LocalDateTime start;
    private LocalDateTime end;
}
