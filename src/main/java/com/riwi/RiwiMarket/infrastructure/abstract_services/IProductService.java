package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;

import java.util.UUID;

public interface IProductService extends GenericService<ProductRequest, ProductResponse,Long>{
    public void addBrandToProduct(Long productId, Long brandId);
}
