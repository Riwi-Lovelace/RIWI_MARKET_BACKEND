package com.riwi.RiwiMarket.api.dtos.responses;

import com.riwi.RiwiMarket.util.enums.RoleEmployee;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToStoreResponse {
    private Long id;
    private String name;
    private String document;
    private String email;
    private RoleEmployee role;
    private String phone;
    private String address;
    private Integer schedule;

}
