package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
