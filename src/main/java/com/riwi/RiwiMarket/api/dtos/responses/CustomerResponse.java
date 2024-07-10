package com.riwi.RiwiMarket.api.dtos.responses;

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
public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String document;
}
