package com.riwi.RiwiMarket.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 100)
    private String address;

    @Column(length = 50)
    private String password;
    
    @Column(length = 20)
    private String document;

   @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "customer",
    cascade = CascadeType.ALL)
    private List<Sale> loss;
}
