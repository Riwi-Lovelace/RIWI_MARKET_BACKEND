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
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface RefundRepository extends JpaRepository<Refund, Long>{


     // Page<Refund> findByMethodOrReasonOrDateBetween(Method method,Reason reason, PageRequest request,LocalDate date,LocalDate dateEnd);
     @Query("SELECT r FROM refund r WHERE" + 
     "(:method IS NULL OR r.method = :method) AND " + 
     "(:reason IS NULL OR r.reason = :reason) AND " + 
     "(:start IS NULL OR :end IS NULL OR r.date BETWEEN :start  AND :end  )")
     Page<Refund>getall(PageRequest request, @Param("method") Method method,@Param("reason") Reason reason,@Param("start") LocalDate start,@Param("end") LocalDate end);

    /*Page<Refund> findByMethodOrReasonOrDateBetween(Method method, Reason reason, LocalDateTime startDate, LocalDateTime endDate, PageRequest pageRequest);*/
}
