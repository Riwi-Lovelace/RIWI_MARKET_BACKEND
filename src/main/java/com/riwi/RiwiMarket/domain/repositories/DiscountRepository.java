package com.riwi.RiwiMarket.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.api.dtos.responses.DiscountResponse;
import com.riwi.RiwiMarket.domain.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    //Method to search for discount by description 
    List<Discount>findByDescriptionContaining(String description);
    
    //Method to search for amount discount
    List<Discount>findByAmount(double amount);
}
