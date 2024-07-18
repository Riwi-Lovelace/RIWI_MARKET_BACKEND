package com.riwi.RiwiMarket.domain.repositories;


import com.riwi.RiwiMarket.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findBySubcategory_Id (Long id);
    public List<Product> findByBrand_id(Long id);

    //Method to serch for product by name
   List<Product>findByName(String name);



}
