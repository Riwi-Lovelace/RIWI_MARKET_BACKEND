package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e FROM expense e WHERE" +
            "(:id IS NULL OR e.id = :id) AND" +
            "(:)")
    Page<Expense>getAll(PageRequest request, @Param("id") Long id, @Param("min")BigDecimal min, @Param("max")BigDecimal max, @Param("description") String description, @Param("start")LocalDate start,@Param("end")LocalDate end,@Param(""))
}
