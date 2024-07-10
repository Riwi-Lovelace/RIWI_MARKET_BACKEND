package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Employee;
import com.riwi.RiwiMarket.util.enums.RoleEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
 List<Employee> findByName(String name);

 List<Employee> findByRole(RoleEmployee role);
}
