package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    
        Page<Supplier> findByNameContainingOrContactContainingOrAddressContainingOrStatus(
                PageRequest pageRequest, String name, String contact, String address, Boolean status);
    
}
