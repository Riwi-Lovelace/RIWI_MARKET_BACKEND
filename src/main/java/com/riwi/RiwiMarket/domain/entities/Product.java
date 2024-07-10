package com.riwi.RiwiMarket.domain.entities;

import java.util.List;
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
<<<<<<< HEAD
    @Column(unique = true, length = 13)
    private String id;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 13)
    private Long id;

>>>>>>> origin/develop
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;
<<<<<<< HEAD
    @Column(nullable = false, columnDefinition = "DECIMAL(2,2)")
=======
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
>>>>>>> origin/develop
    private BigDecimal iva;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    private Subcategory subcategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "product",
    cascade = CascadeType.ALL)
    private List<Batch> batches;
}
