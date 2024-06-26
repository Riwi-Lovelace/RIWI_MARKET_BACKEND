package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Supplier;
import java.util.List;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByName(String name);
    List<Supplier> findByContact(String contact);
    List<Supplier> findByAddress(String address);
    List<Supplier> findByStatus(Boolean status);
}
