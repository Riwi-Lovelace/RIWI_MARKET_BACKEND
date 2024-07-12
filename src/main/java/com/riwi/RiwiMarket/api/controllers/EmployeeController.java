package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IEmployeeController;
import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.riwi.RiwiMarket.infrastructure.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import com.riwi.RiwiMarket.util.enums.SortCustomer;
import com.riwi.RiwiMarket.util.enums.SortEmployee;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @ApiResponse(
        responseCode = "200",
        description = "Successful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "when send word is invalid",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @PostMapping
    @Operation(summary = "Create an employee", description = "this service aims to create a new employee with all the data brought in from a request.")
    @Override
    public ResponseEntity<EmployeeResponse> create(@Validated @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(this.employeeService.create(request));
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
