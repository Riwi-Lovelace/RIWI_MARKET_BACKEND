package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Subcategory;
@Primary
@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    
}
