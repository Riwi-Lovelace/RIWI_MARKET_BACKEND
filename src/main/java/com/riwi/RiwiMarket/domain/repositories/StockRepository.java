package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Category;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Batch;
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
    //this Query search by product name or categoryName and can search the same word or contains part of the word
    @Query("SELECT s FROM stock s " +
            "JOIN s.batch b " +
            "JOIN b.product p " +
            "JOIN p.subcategory sc " +
            " JOIN sc.category c " +
            "WHERE (:productName IS NULL OR s.batch.product.name LIKE %:productName%) AND " +
            "(:categoryName IS NULL OR s.batch.product.subcategory.category.name LIKE %:categoryName%)")
    Page<Stock> getall(PageRequest request, @Param("productName")String productName, @Param("categoryName")String categoryName);

}

    Stock findByBatch(Batch batch);

}
