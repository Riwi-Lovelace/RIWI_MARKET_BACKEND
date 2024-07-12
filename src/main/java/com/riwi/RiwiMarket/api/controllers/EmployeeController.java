package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IEmployeeController;
import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;
import com.riwi.RiwiMarket.infrastructure.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import com.riwi.RiwiMarket.util.enums.SortCustomer;
import com.riwi.RiwiMarket.util.enums.SortEmployee;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public ResponseEntity<EmployeeResponse> read(Long id) {
        return null;
    }

    @Override
    @PutMapping(path = "update/{id}")
    @Operation(summary = "Update a employee",description = "update any employee selected by id, those with the role of admin are able to modify all information but Seller role can only modify email, phone and address")
    public ResponseEntity<EmployeeResponse> update(@Validated @RequestBody EmployeeRequest request,@PathVariable Long id) {
        return ResponseEntity.ok(this.employeeService.update(id,request));
    }


    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> getAll(@RequestParam(defaultValue = "5") int size,
                                                         @RequestParam(defaultValue = "1") int page,
                                                         @RequestHeader(required = false)SortEmployee sortEmployee) {
        if (Objects.isNull(sortEmployee)) sortEmployee = SortEmployee.NONE;
        return ResponseEntity.ok(this.employeeService.getAll(size,page ,sortEmployee));
    }

}
