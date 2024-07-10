package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.domain.entities.Employee;
import com.riwi.RiwiMarket.domain.repositories.EmployeeRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
        return null;
    }

    @Override
    public EmployeeResponse read(Long id) {
        return null;
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<EmployeeResponse> getAll(int page, int size) {
        return null;
    }

    //function to convert ArrayList of an entity to Page of entity
    private <T> Page<T> convertListToPage(List<T> list, int page, int size) {
        int start = (int) PageRequest.of(page, size).getOffset();
        int end = Math.min((start + PageRequest.of(page, size).getPageSize()), list.size());
        List<T> subList = list.subList(start, end);
        return new PageImpl<>(subList, PageRequest.of(page, size), list.size());
    }
}
