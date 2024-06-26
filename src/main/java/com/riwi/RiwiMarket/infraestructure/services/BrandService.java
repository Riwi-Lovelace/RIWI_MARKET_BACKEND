package com.riwi.RiwiMarket.infraestructure.services;

import com.riwi.RiwiMarket.api.dto.mappers.BrandMapper;
import com.riwi.RiwiMarket.api.dto.request.BrandRequest;
import com.riwi.RiwiMarket.api.dto.response.BrandResponse;
import com.riwi.RiwiMarket.domain.entities.Brand;
import com.riwi.RiwiMarket.domain.repositories.BrandRepository;
import com.riwi.RiwiMarket.infraestructure.abstrac_service.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandService implements IBrandService {
    @Autowired
    private final BrandRepository brandRepository;
    @Autowired
    private final BrandMapper brandMapper;

    @Override
    public BrandResponse create(BrandRequest request) {
        Brand brand=brandMapper.requestToBrand(request);
        Brand savedBrand=brandRepository.save(brand);
        return brandMapper.responseToBrand(savedBrand);
    }
}
