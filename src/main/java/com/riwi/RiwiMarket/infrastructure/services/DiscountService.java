package com.riwi.RiwiMarket.infrastructure.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.DiscountRequest;
import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.domain.entities.Discount;
import com.riwi.RiwiMarket.domain.repositories.DiscountRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IDiscountService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.DiscountMapper;

import com.riwi.RiwiMarket.util.exceptions.BadRequestException;


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
             Discount discount = this.mapper.toUserEntity(request);
            return this.mapper.toUserResponse(this.discountRepository.save(discount));


    }

    @Override
    public DiscountResponse read(Long id) {
       // TODO Auto-generated method stub
       throw new UnsupportedOperationException("Unimplemented method 'create'");
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
        return this.discountMapper.toUserResponse(this.find(id));
    }

    @Override
    public Page<DiscountResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination= PageRequest.of(page, size);

        return this.discountRepository.findAll(pagination)
                            .map(this.discountMapper::toUserResponse);
    }

    @Override
    public List<DiscountResponse> findByDescriptionContaining(String description) {
        
        return this.discountRepository.findByDescriptionContaining(description)
        .stream()
        .map(this.discountMapper::toUserResponse)
        .collect(Collectors.toList());
    }

    @Override
    public List<DiscountResponse> findByAmount(double amount) {
        return this.discountRepository.findByAmount(amount)
        .stream()
        .map(this.discountMapper::toUserResponse)
        .collect(Collectors.toList());
    }

    /*********/
    private Discount find(Long id){
        return this.discountRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("There is no discount with the provided id"));
    }

    public List<Discount> findAll() {
        List<Discount> discounts = discountRepository.findAll();
        return discounts;
    }

}
