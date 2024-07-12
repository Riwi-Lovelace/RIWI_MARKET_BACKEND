package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //Method to serch for product by name
   List<Product>findByName(String name);

    //Method to serch for product by subcategory
    List<Product>findBySubcategoryId(Long id);


}
