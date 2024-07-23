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
public class SupplierResponse {

    private int id;
    private String name;
    private String contact;
    private String schedule;
    private String address;
    private Boolean status;

}
