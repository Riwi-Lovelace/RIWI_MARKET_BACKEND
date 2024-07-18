package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Category;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    //Add here the advanced queries to databases

    @Query("SELECT r FROM stock r WHERE" +
            "(:productName IS NULL OR r.batch.product.name = :productName) AND" +
            "(:categoryName IS NULL OR r.batch.product.subcategory.category.name = :categoryName)")
    Page<Stock> getall(PageRequest request, @Param("productName")String productName, @Param("categoryName")String categoryName);

}


// getAll(String productName, String categoryName, int size, int page, GeneralSort generalSort)