package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.domain.entities.Product;
/*import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.domain.repositories.SubcategoryRepository;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;*/

import lombok.AllArgsConstructor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
//import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProductMapper{

    //@Autowired
    //private final SubcategoryRepository subcategoryRepository;

    //@Autowired
    //private final SupportService supportService;

    @Mapping(target = "id", ignore = true)
    public Product toEntity(ProductRequest productRequest){
        if ( productRequest == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.iva( productRequest.getIva() );
        product.name( productRequest.getName() );
        product.status( productRequest.getStatus() );
        product.urlImg( productRequest.getUrlImg() );
        //product.subcategory((Subcategory) supportService.findById(subcategoryRepository, productRequest.getSubcategory(), "subcategory"));

        return product.build();
    };

    abstract public ProductResponse toResponse(Product productEntity);

}
