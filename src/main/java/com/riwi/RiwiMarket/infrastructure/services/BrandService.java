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
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

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
        return brandRepository.findByNameContaining(name, pageable).map(brandMapper::toResponse);
    }

    @Override
    public BrandResponse create(BrandRequest request) {
        // Verificar si ya existe una marca con el mismo nombre
        if (brandRepository.existsByName(request.getName())) {
            throw new BadRequestException("Brand with the same name already exists");
        }

        Brand savedBrand = brandRepository.save(brandMapper.toEntity(request));
        return brandMapper.toResponse(savedBrand);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BrandResponse read(Long id) {
        return brandMapper.toResponse(supportService.findById(brandRepository, id, "brand"));
    }

    @Override
    public BrandResponse update(Long id, BrandRequest request) {
        Brand existingBrand = supportService.findById(brandRepository, id, "brand");

        // Eliminar marca si el nombre ha cambiado y ya existe una marca con el nuevo nombre
        if (request.getName() != null && !request.getName().isEmpty() && !request.getName().equals(existingBrand.getName())) {
            if (brandRepository.existsByName(request.getName())) {
                deleteByName(request.getName());
            }
            existingBrand.setName(request.getName());
        }

        if (request.getStatus() != null) {
            existingBrand.setStatus(request.getStatus());
        }

        Brand updatedBrand = brandRepository.save(existingBrand);
        return brandMapper.toResponse(updatedBrand);
    }

    @Override
    public void deleteByName(String name) {
        Brand brand = brandRepository.findByName(name);
        brandRepository.delete(brand);
    }

}
