package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequest {
    @NotBlank(message = "name is required")
    @Size(min = 0, max = 100, message = "name exceeds the number of characters allowed(100)")
    private String name;
    @NotBlank(message = "address is required")
    @Size(min = 0, max = 100, message = "address exceeds the number of characters allowed(100)")
    private String address;
    @Email(message = "the email format must be valid")
    @NotBlank(message = "email is required")
    @Size(min = 0, max = 100, message = "email exceeds the number of characters allowed(100)")
    private String email;
    @NotBlank(message = "phone is required")
    @Size(min = 0, max = 15, message = "phone exceeds the number of characters allowed(15)")
    private String phone;
    @Size(min = 0, max = 12, message = "nit exceeds the number of characters allowed(12)")
    private String nit;

}
