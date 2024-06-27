package com.riwi.RiwiMarket.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.domain.entities.Discount;
import com.riwi.RiwiMarket.domain.repositories.DiscountRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IDiscountService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.DiscountMapper;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscountService implements IDiscountService {
    @Autowired
    private final DiscountRepository discountRepository;
    private final DiscountMapper mapper;


    @Override
    public DiscountResponse create(DiscountRequest request) {
             Discount discount = this.mapper.toUserEntity(request);
            return this.mapper.toUserResponse(this.discountRepository.save(discount));


    }

    @Override
    public DiscountResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public DiscountResponse update(Long id, DiscountRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public DiscountResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

}
