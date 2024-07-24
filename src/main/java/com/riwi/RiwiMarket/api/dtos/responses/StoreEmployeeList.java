package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreEmployeeList {
    private Long id;
    private String name;
    private String role;
}
