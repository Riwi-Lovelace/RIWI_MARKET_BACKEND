package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.RiwiMarket.domain.entities.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    
}
