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
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product= this.productMapper.toEntity(request);
        //Subcategory subcategory= this.supportSubcategory.findById(this.subcategoryRepository ,request.getSubcategory(),"SubCategory");

        //product.setSubcategory(subcategory);
        product.setStatus(true);
        return this.productMapper.toResponse(this.productRepository.save(product));
    }

    @Override
    public ProductResponse read(Long id) {
        return this.productMapper.toResponse(this.find(id));
    }

    @Override
    public ProductResponse update(Long aLong, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<ProductResponse> findByName(String name) {
        return this.productRepository.findByName(name)
        .stream()
        .map(this.productMapper::toResponse)
        .collect(Collectors.toList());
    }
    /*/
    @Override
    public List<ProductResponse> findBySubcategoryId(Long id) {
        return this.productRepository.findBySubcategoryId(id)
        .stream()
        .map(this.productMapper::toResponse)
        .collect(Collectors.toList());
    }*/

    @Override
    public Page<ProductResponse> getAll(int page, int size) {
        if(page < 0)
            page = 0; 
        PageRequest pagination = PageRequest.of(page, size);

        return this.productRepository.findAll(pagination)
            .map(this.productMapper::toResponse);
    }

    private Product find(Long id){
        return this.productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("There is not prodcut with the provided id"));
    }
}
