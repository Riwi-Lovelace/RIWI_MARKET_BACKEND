package com.riwi.RiwiMarket.infrastructure.abstract_services;

import java.math.BigDecimal;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;

public interface IProductService extends GenericService<ProductRequest, ProductResponse,Long>{
    ProductResponse updateProductDescription(Long id, String description);
    ProductResponse addProductPrice(Long id, BigDecimal price);
}
