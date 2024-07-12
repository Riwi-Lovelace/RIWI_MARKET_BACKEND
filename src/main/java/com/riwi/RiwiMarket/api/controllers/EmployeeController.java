package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IEmployeeController;
import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IEmployeeService;
import com.riwi.RiwiMarket.util.enums.SortCustomer;
import com.riwi.RiwiMarket.util.enums.SortEmployee;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<EmployeeResponse> update(EmployeeRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

//    @GetMapping
//    public ResponseEntity<Page<EmployeeResponse>> getAll(@RequestParam(defaultValue = "5") int size,
//                                                         @RequestParam(defaultValue = "1") int page,
//                                                         @RequestHeader(required = false)SortEmployee sortEmployee) {
//        if (Objects.isNull(sortEmployee)) sortEmployee = SortEmployee.NONE;
//        return ResponseEntity.ok(this.employeeService.getAll(size,page ,sortEmployee));
//    }

    @GetMapping
    public List<EmployeeResponse> getAll() {

        return this.employeeService.getAllNoPage();
    }

    @GetMapping(path = "/paginate")
   public ResponseEntity<Page<EmployeeResponse>> getAllPage(@RequestParam(defaultValue = "1") int page,
                                                            @RequestParam(defaultValue = "5") int size,
                                                            @RequestHeader(required = false) SortEmployee sortEmployee){

        if (Objects.isNull(sortEmployee)) sortEmployee = SortEmployee.NONE;
        return ResponseEntity.ok(this.employeeService.getAll(page,size,sortEmployee));
    }

}
