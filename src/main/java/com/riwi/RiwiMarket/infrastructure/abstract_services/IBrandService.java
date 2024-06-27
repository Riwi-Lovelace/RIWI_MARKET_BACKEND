package com.riwi.RiwiMarket.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.RiwiMarket.api.dtos.requests.BrandRequest;
import com.riwi.RiwiMarket.api.dtos.responses.BrandResponse;


public interface IBrandService extends GenericService<BrandRequest, BrandResponse, Long>
{
    Page<BrandResponse> search(String name, Pageable pageable);
}
