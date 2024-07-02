package com.riwi.RiwiMarket.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

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
    private DiscountMapper mapper;
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public DiscountResponse create(DiscountRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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

    public List<Discount> findAll() {
        List<Discount> discounts = discountRepository.findAll();
        return discounts;
    }

}
