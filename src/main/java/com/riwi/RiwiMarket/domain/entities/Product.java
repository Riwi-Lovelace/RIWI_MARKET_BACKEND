package com.riwi.RiwiMarket.domain.entities;

import com.riwi.RiwiMarket.util.enums.StatusProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(unique = true, length = 13)
    private String id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "DECIMAL(2,2)")
    private BigDecimal iva;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProduct status;
}
