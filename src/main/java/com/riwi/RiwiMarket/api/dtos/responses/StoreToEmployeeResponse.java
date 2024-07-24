package com.riwi.RiwiMarket.api.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreToEmployeeResponse {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String nit;
    private BigDecimal available;
}
