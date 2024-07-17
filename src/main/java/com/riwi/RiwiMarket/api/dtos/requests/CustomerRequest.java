package com.riwi.RiwiMarket.api.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    
    @Size(min = 0, max = 50, message = "Name exceeds the number of characters allowed(50)")
    @NotBlank(message = "Customer name is required")
    private String name;

    @Size(
        min = 1, 
        max = 100, 
        message = "The email must be between 1 and 100 characters"
    )
    @Email
    private String email;

    @Size(min = 0, max = 15, message = "The contact number exceeds the number of characters allowed.(15)")
    private String phone;

    @Size(min = 0, max = 100, message = "The address exceeds the number of characters allowed(100)")
    private String address;

    @Size(min = 8, max = 50, message = "The password must be between 8 and 50 characters long")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$", message = "The password must have at least one capital letter and one number.")
    private String password;
    
    @Size(min = 0, max = 15, message = "The document exceeds the number of characters allowed.(20)")
    @Pattern(regexp = "^[0-9]+$", message = "The identity card must contain only numbers")
    private String document;
}
