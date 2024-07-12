package com.riwi.RiwiMarket.infrastructure.abstract_services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;

public interface IProductService extends GenericService<ProductRequest, ProductResponse,Long>{

    //Method to serch for product by name
    List<ProductResponse>findByName(String name);

    //Method to serch for product by subcategory
    //List<ProductResponse>findBySubcategoryId(Long id);

    //Listar todos
    Page<ProductResponse> getAll(int page, int size);
}
