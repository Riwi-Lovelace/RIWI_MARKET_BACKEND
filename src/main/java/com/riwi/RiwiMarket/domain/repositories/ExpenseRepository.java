package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Employee;
import com.riwi.RiwiMarket.domain.entities.Expense;
import com.riwi.RiwiMarket.domain.entities.Supplier;
import com.riwi.RiwiMarket.util.enums.Status;
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
            "(:min IS NULL OR :max IS NULL OR e.amount BETWEEN :min AND :max)"+
            "(:description IS NULL OR e.description LIKE %:description%) AND" +
            "(:supplierId IS NULL OR e.supplierId = :supplierId) AND" +
            "(:employeeId IS NULL OR e.employeeId = :employeeId) AND" +
            "(:start IS NULL OR :end IS NULL OR e.date BETWEEN :start AND :end)")

    Page<Expense>getAll(PageRequest request,
                        @Param("id") Long id,
                        @Param("min")BigDecimal min, @Param("max")BigDecimal max,
                        @Param("description") String description,
                        @Param("start")LocalDate start, @Param("end")LocalDate end,
                        @Param("paidStatus") Status paidStatus,
                        @Param("supplierId") Supplier supplierId,
                        @Param("employeeId") Employee employeeId);
}
