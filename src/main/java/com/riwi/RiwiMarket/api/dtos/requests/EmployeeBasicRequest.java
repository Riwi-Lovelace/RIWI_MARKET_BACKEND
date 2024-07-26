package com.riwi.RiwiMarket.api.dtos.requests;


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
public class EmployeeBasicRequest {
    @NotBlank(message = "email is required")
    @Size(min = 0, max = 100, message = "email exceeds the number of characters allowed(100)")
    private String email;
    @NotNull(message = "role is required")
    @Size(min = 0, max = 15, message = "phone exceeds the number of characters allowed(15)")
    private String phone;
    @NotBlank(message = "address is required")
    @Size(min = 0, max = 100, message = "address exceeds the number of characters allowed(100)")
    private String address;
}
