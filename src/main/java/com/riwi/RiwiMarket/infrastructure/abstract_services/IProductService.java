package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.domain.entities.Product;

import java.util.Map;

public interface IProductService extends GenericService<ProductRequest, ProductResponse,Long>{
    Map<String, String> archiveProduct(Long productId);

    Map<String, String> unarchiveProduct(Long productId);
}
