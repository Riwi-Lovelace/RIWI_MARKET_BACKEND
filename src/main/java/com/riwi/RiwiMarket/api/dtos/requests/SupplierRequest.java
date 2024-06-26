package com.riwi.RiwiMarket.api.dtos.requests;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRequest {

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name cannot be longer than 100 characters")
        private String name;

        @NotBlank(message = "Contact is required")
        @Size(max = 100, message = "Contact cannot be longer than 100 characters")
        private String contact;

        @Size(max = 100, message = "Schedule cannot be longer than 100 characters")
        private String schedule;

        @NotBlank(message = "Address is required")
        @Size(max = 100, message = "Address cannot be longer than 100 characters")
        private String address;
        
}
