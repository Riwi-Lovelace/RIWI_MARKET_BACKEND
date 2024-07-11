package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IEmployeeController;
import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
