package com.riwi.RiwiMarket.api.dtos.errors;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError implements Serializable {
    private String status;
    private Integer code;
    private Map<String, String> error;
}