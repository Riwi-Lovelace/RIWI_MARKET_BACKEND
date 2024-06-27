package com.riwi.RiwiMarket.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.BrandRequest;
import com.riwi.RiwiMarket.api.dtos.responses.BrandResponse;
import com.riwi.RiwiMarket.domain.entities.Brand;
import com.riwi.RiwiMarket.domain.repositories.BrandRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IBrandService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.BrandMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandService implements IBrandService
{
    @Autowired
    private final SupportService<Brand> supportService;

    @Autowired
    private final BrandMapper brandMapper;

    @Autowired
    private final BrandRepository brandRepository;

    @Override
    public Page<BrandResponse> search(String name, Pageable pageable)
    {
        return brandRepository.findByName(name, pageable).map(brandMapper::toUserResponse);
    }

    @Override
    public BrandResponse create(BrandRequest request) {
        Brand brand=brandMapper.toUserEntity(request);
        Brand savedBrand=brandRepository.save(brand);
        return brandMapper.toUserResponse(savedBrand);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BrandResponse read(Long id) {
        return brandMapper.toUserResponse(supportService.findById(id, "brand"));
    }

    @Override
    public BrandResponse update(Long id, BrandRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
