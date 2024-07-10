package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.domain.entities.Store;
import com.riwi.RiwiMarket.util.enums.RoleEmployee;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String name;
    private String document;
    private String email;
    private RoleEmployee role;
    private String phone;
    private String address;
    private String password;
    private BigDecimal salary;
    private Integer schedule;
    private Store storeId;
}
