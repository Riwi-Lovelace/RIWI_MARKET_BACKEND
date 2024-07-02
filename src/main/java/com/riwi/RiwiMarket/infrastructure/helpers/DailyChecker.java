package com.riwi.RiwiMarket.infrastructure.helpers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.riwi.RiwiMarket.domain.entities.Discount;
import com.riwi.RiwiMarket.domain.repositories.DiscountRepository;
import com.riwi.RiwiMarket.infrastructure.services.DiscountService;

@Component
@EnableScheduling
public class DailyChecker {
  @Autowired
  private DiscountService discountService;

  @Scheduled(cron = "* * * * *")
  public void verificaPorHora() {
    System.out.println(LocalDateTime.now());
    List<Discount> discounts = discountService.findAll();
    for (Discount discount : discounts) {

    }
  }
}