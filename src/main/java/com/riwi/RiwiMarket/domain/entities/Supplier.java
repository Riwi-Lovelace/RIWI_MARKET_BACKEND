package com.riwi.RiwiMarket.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "supplier")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String contact;
    @Column(length = 100)
    private String schedule;
    @Column(length = 100)
    private String address;
    @Column(nullable = false)
    private Boolean status;
    
}
