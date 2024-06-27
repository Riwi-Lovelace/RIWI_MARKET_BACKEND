package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>
{
    Page<Brand> findByNameContaining(String name, Pageable pageable);
}
