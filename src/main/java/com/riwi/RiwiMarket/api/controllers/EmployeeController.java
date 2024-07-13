package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IEmployeeController;
import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Employee")
@AllArgsConstructor
@Tag(name = "Employee")
public class EmployeeController implements IEmployeeController {

    @Autowired
    private final IEmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeResponse> create(EmployeeRequest request) {
        return null;
    }

    @Override
    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Get information of an employee.",
            description = "In this section you will find info of an employee by giving his/her Id.")
    public ResponseEntity<EmployeeResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.read(id));
    }

    @Override
    public ResponseEntity<EmployeeResponse> update(EmployeeRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<EmployeeResponse>> getAll() {
        return null;
    }
}
