package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;

<<<<<<< HEAD
import com.riwi.RiwiMarket.util.enums.MethodRefund;
import com.riwi.RiwiMarket.util.enums.ReasonRefund;
=======
import org.hibernate.annotations.CreationTimestamp;

import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
>>>>>>> origin/develop

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "refund")
<<<<<<< HEAD
@Data
=======
@Getter
@Setter
>>>>>>> origin/develop
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Refund {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
<<<<<<< HEAD
    private MethodRefund method;
    @Column(nullable = false)
    private ReasonRefund reason;
=======
    @Enumerated(EnumType.STRING)
    private Method method;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Reason reason;

>>>>>>> origin/develop
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime date;
    
    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
}
