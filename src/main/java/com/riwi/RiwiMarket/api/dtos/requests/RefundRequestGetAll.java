package com.riwi.RiwiMarket.api.dtos.requests;

import java.time.LocalDate;

import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefundRequestGetAll {

    private int page;
    private int size;
    private Method method;
    private Reason reason;
    @PastOrPresent(message = "The date end must be a past date")
    private LocalDate date;
    @PastOrPresent(message = "The date end must be a past date")
    private LocalDate dateEnd;
}
