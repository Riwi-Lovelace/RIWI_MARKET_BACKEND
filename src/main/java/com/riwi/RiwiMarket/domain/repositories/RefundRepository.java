package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface RefundRepository extends JpaRepository<Refund, Long>{

     // Page<Refund> findByMethodOrReasonOrDateBetween(Method method,Reason reason, PageRequest request,LocalDate date,LocalDate dateEnd);
     @Query("SELECT r FROM refund r WHERE" + 
     "(:method IS NULL OR r.method = :method) AND " + 
     "(:reason IS NULL OR r.reason = :reason) AND " + 
     "(:start IS NULL OR :end IS NULL OR r.date BETWEEN :start  AND :end  )")
     Page<Refund>getall(PageRequest request, @Param("method") Method method,@Param("reason") Reason reason,@Param("start") LocalDate start,@Param("end") LocalDate end);
    
}

/*
@Query("SELECT e FROM Expense e WHERE" +
        " (:id IS NULL OR e.id = :id) AND" +
        " (:min IS NULL OR :max IS NULL OR e.amount BETWEEN :min AND :max) AND" +
        " (:description IS NULL OR e.description LIKE %:description%) AND" +
        " (:paidStatus IS NULL OR e.paidStatus = :paidStatus) AND" +
        " (:supplierId IS NULL OR e.supplierId = :supplierId) AND" +
        " (:employeeId IS NULL OR e.employeeId = :employeeId) AND" +
        " (:start IS NULL OR :end IS NULL OR e.date BETWEEN :start AND :end)")*/
