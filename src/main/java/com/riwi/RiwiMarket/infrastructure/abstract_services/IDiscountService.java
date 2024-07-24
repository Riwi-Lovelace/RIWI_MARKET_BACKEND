package com.riwi.RiwiMarket.infrastructure.abstract_services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;

public interface IDiscountService extends GenericService<DiscountRequest, DiscountResponse, Long> {
    public DiscountResponse getById(Long id);

    List<DiscountResponse>findByDescriptionContaining(String description);
    
    List<DiscountResponse>findByAmount(double amount);

    Page<DiscountResponse> getAll(int page, int size);
}