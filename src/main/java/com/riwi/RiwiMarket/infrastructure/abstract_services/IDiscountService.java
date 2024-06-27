package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;

public interface IDiscountService extends GenericService<DiscountRequest, DiscountResponse, Long> {
    public DiscountResponse getById(Long id);
}