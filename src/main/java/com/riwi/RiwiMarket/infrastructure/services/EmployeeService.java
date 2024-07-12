package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.domain.entities.Employee;
import com.riwi.RiwiMarket.domain.repositories.EmployeeRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.EmployeeMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;
import com.riwi.RiwiMarket.util.enums.RoleEmployee;
import com.riwi.RiwiMarket.util.enums.SortCustomer;
import com.riwi.RiwiMarket.util.enums.SortEmployee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final EmployeeMapper employeeMapper;

    @Autowired
    private final SupportService<Employee> supportService;

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        if (!employeeRepository.findByDocument(request.getDocument()).isEmpty()) {
            throw new BadRequestException("There is already an employee with such a document");
        }

        Employee saveEmployee = employeeRepository.save(employeeMapper.toEntity(request));
        return employeeMapper.toResponse(saveEmployee);
    }

    @Override
    public EmployeeResponse read(Long id) {
        return null;
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
       Employee employee = this.supportService.findById(employeeRepository, id,"employee");

       RoleEmployee initialRole = employee.getRole();

       if (initialRole == RoleEmployee.ADMIN){
           employee.setName(request.getName());
           employee.setDocument(request.getDocument());
           employee.setEmail(request.getEmail());
           employee.setPhone(request.getPhone());
           employee.setAddress(request.getAddress());
           employee.setPassword(request.getPassword());
           employee.setSalary(request.getSalary());
           employee.setRole(request.getRole());
           employee.setSchedule(request.getSchedule());
       }else {
           employee.setEmail(request.getEmail());
           employee.setPhone(request.getPhone());
           employee.setAddress(request.getAddress());
       }

       Employee updatedEmployee = employeeRepository.save(employee);
       return employeeMapper.toResponse(updatedEmployee);


    }

    @Override
    public void delete(Long id) {

    }


    public Page<EmployeeResponse> getAll(int page, int size, SortEmployee sortEmployee) {
        if (page < 0) page = 0;

        PageRequest pagination = null;

        switch (sortEmployee){
            case NONE -> pagination  = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).descending());
        }

        System.out.println("lo que devuelve de empleados " + this.employeeRepository.findAll());
        for(Employee employee: this.employeeRepository.findAll()){
            System.out.println("name" + employee.getName());
            System.out.println("email" + employee.getEmail());
            System.out.println("role" + employee.getRole());
            System.out.println("Phone" + employee.getPhone());
            System.out.println("CashMachines" + employee.getCashMachines());
            System.out.println("Payroll" + employee.getPayrolls());
            System.out.println("Expense" + employee.getExpenses());
        }
        return this.employeeRepository.findAll(pagination).map(this.employeeMapper::toResponse);
    }

    //function to convert ArrayList of an entity to Page of entity
    private <T> Page<T> convertListToPage(List<T> list, int page, int size) {
        int start = (int) PageRequest.of(page, size).getOffset();
        int end = Math.min((start + PageRequest.of(page, size).getPageSize()), list.size());
        List<T> subList = list.subList(start, end);
        return new PageImpl<>(subList, PageRequest.of(page, size), list.size());
    }

}
