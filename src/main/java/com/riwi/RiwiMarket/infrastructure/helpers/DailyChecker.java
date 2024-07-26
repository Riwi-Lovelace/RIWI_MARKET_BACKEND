package com.riwi.RiwiMarket.infrastructure.helpers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.riwi.RiwiMarket.domain.entities.Discount;
import com.riwi.RiwiMarket.infrastructure.services.DiscountService;

@Component
@Configuration
@EnableScheduling
public class DailyChecker {
    @Autowired
    private DiscountService discountService;

    @Scheduled(cron = "0 6 * * * *")
    public void verificaPorHora() {
        System.out.println(LocalDateTime.now());
        List<Discount> discounts = discountService.findAll();
        for (Discount discount : discounts) {
            if (discount.getEndDiscount() != null && discount.getEndDiscount().isBefore(LocalDateTime.now())) {
                this.discountService.delete(discount.getId());
                System.out.println(discount);
            }
        }
    }
}