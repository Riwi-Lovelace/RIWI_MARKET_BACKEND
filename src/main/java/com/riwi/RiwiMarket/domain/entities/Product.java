package com.riwi.RiwiMarket.domain.entities;

import com.riwi.RiwiMarket.util.enums.StatusProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 13)
    private String id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "DECIMAL(0,2)")
    private BigDecimal iva;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProduct status;
    private int brandId;
    @Column(nullable = false)
    private int subCategoryId;
}
