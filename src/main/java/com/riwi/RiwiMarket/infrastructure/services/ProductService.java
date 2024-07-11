package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.domain.entities.Brand;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.domain.repositories.BrandRepository;
import com.riwi.RiwiMarket.domain.repositories.ProductRepository;
import com.riwi.RiwiMarket.domain.repositories.SubcategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ProductMapper;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final SupportService<Product> SupportService;
    @Autowired
    private final SubcategoryRepository subcategoryRepository;
    @Autowired
    private final SupportService<Subcategory> supportSubcategory;
    @Autowired
    private final BrandRepository brandRepository;



    @Override
    public ProductResponse create(ProductRequest request) {
        Product product= this.productMapper.toEntity(request);
        Subcategory subcategory= this.supportSubcategory.findById(this.subcategoryRepository ,request.getSubcategory(),"SubCategory");

        product.setSubcategory(subcategory);
        return this.productMapper.toResponse(this.productRepository.save(product));
    }

    @Override
    public ProductResponse read(Long aLong) {
        return null;
    }

    @Override
    public ProductResponse update(Long aLong, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void addBrandToProduct(Long productId, Long brandId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BadIdException("Product not found with the provided ID: " + productId));

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new BadIdException("Brand not found with the provided ID: " + brandId));

        product.setBrand(brand);
        productRepository.save(product);
    }
}
