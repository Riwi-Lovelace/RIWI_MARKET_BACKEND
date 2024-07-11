package com.riwi.RiwiMarket.api.dtos.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String nit;
    private BigDecimal available;
    private List<StoreEmployeeList> employees;
}
