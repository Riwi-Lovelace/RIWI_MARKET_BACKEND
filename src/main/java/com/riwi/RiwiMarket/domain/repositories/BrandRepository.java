package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository  extends JpaRepository<Brand, Long> {
}
