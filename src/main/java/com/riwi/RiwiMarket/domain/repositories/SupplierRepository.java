package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Page<Supplier> findByName(String name, Pageable pageable);
    Page<Supplier> findByContact(String contact, Pageable pageable);
    Page<Supplier> findByAddress(String address, Pageable pageable);
    Page<Supplier> findByStatus(Boolean status, Pageable pageable);
    
    Page<Supplier> findAll(Pageable pageable);
}
