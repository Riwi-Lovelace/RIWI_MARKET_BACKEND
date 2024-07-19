package com.riwi.RiwiMarket.api.dtos.requests;

import com.riwi.RiwiMarket.util.enums.RoleEmployee;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "name is required")
    @Size(min = 0, max = 50, message = "name exceeds the number of characters allowed(50)")
    private String name;
    @Size(min = 0, max = 50, message = "document exceeds the number of characters allowed(20)")
    @NotBlank(message = "document is required")
    private String document;
    @NotBlank(message = "email is required")
    @Email(message = "the email format must be valid")
    @Size(min = 0, max = 100, message = "email exceeds the number of characters allowed(100)")
    private String email;
    @NotNull(message = "role is required")
    private RoleEmployee role;
    @Size(min = 0, max = 15, message = "phone exceeds the number of characters allowed(15)")
    private String phone;
    @NotBlank(message = "address is required")
    @Size(min = 0, max = 100, message = "address exceeds the number of characters allowed(100)")
    private String address;
    @NotBlank(message = "password is required")
    @Size(min = 0, max = 50, message = "password exceeds the number of characters allowed(50)")
    private String password;
    @NotNull(message = "salary is required")
    @DecimalMin("0.00")
    private BigDecimal salary;
    @NotNull(message = "schedule is required")
    private Integer schedule;
    private Long store_id;
}
