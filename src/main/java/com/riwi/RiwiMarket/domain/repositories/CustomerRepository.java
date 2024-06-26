package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
