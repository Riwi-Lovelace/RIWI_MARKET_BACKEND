package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.domain.repositories.ProductRepository;
import com.riwi.RiwiMarket.domain.repositories.SubcategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ProductMapper;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product= this.productMapper.toEntity(request);
        Subcategory subcategory= this.supportSubcategory.findById(this.subcategoryRepository ,request.getSubcategory(),"SubCategory");

        product.setSubcategory(subcategory);
        product.setStatus(true);
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

    private Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new BadIdException("Product not found with id: " + productId));
    }
    @Override
    public Map<String, String> archiveProduct(Long productId) {
        Product product = getProductById(productId);
        Map<String, String> response = new HashMap<>();

        if (!product.getStatus()) {
            response.put("message", "Product is already archived.");
        } else {
            product.setStatus(false);
            productRepository.save(product);
            response.put("message", "Product archived successfully.");
        }

        return response;
    }

    @Override
    public Map<String, String> unarchiveProduct(Long productId) {
        Product product = getProductById(productId);
        Map<String, String> response = new HashMap<>();

        if (product.getStatus()) {
            response.put("message", "Product is already active.");
        } else {
            product.setStatus(true);
            productRepository.save(product);
            response.put("message", "Product unarchived successfully.");
        }

        return response;
    }
}
