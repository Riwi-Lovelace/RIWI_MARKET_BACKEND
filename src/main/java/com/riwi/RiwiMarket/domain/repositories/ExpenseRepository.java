package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Expense;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ExpenseRepository extends JpaRepository<Expense, Long> {

   
}
