package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;

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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "return")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Return {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Method method;
    @Column(nullable = false)
    private Reason reason ;
    @Column(nullable = false)
    private LocalDateTime date;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "returnn",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<Item> items;
    
}
