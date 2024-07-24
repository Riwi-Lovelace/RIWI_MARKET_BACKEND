package com.riwi.RiwiMarket.domain.entities;

import java.util.List;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 13)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private BigDecimal iva;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String urlImg;

    @Column(nullable = true)
    private Integer quantityThreshold;

    @Column(nullable = true,columnDefinition = "DECIMAL(5,2)")
    private BigDecimal weightThreshold;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    private Subcategory subcategory;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "product",
    cascade = CascadeType.ALL)
    private List<Batch> batches;

    @Transient
    private  String subcategoryName;
    @Transient
    private  Long IdBrand;

    public Product( String subcategoryName) {this.subcategoryName = subcategoryName;
    }


}
