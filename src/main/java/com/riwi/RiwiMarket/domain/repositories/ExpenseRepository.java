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
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e FROM expense e WHERE" +
            "(:id IS NULL OR e.id = :id) AND" +
            "(:min IS NULL OR :max IS NULL OR e.amount BETWEEN :min AND :max) AND"+
            "((:min IS NULL OR e.amount >= :min) AND (:max IS NULL OR e.amount <= :max)) AND"+
            "(:description IS NULL OR e.description LIKE %:description%) AND" +
            "(:paidStatus IS NULL OR e.paidStatus = :paidStatus) AND" +
            "(:supplierId IS NULL OR e.supplierId.id = :supplierId) AND" +
            "(:employeeId IS NULL OR e.employeeId.id = :employeeId) AND" +
            "(:start IS NULL OR :end IS NULL OR e.specifDate BETWEEN :start AND :end) AND"+
            "((:start IS NULL OR e.specifDate >= :start) AND (:end IS NULL OR e.specifDate <= :end))" )

    Page<Expense>getAll(PageRequest request,
                        @Param("id") Long id,
                        @Param("min")BigDecimal min, @Param("max")BigDecimal max,
                        @Param("description") String description,
                        @Param("start")LocalDate start, @Param("end")LocalDate end,
                        @Param("paidStatus") Status paidStatus,
                        @Param("supplierId") Long supplierId,
                        @Param("employeeId") Long employeeId);

}
