package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.RoleEmployee;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBasicResponse {
    private Long id;
    private String name;
    private String document;
    private RoleEmployee role;
}
