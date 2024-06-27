package com.riwi.RiwiMarket.api.dtos.responses;

import java.time.LocalDate;

public class DiscountResponse {
    private Long id; 
    private String description;    
    private Integer amount;    
    private LocalDate start;    
    private LocalDate end; 
    private Boolean status;
}
