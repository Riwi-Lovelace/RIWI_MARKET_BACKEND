package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/supplier")
@AllArgsConstructor
public class SupplierController implements GenericController{

    @Autowired
    private final ISupplierService supplierService;

    @Override
    public ResponseEntity create(Object request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResponseEntity read(Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public ResponseEntity update(Object request, Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity delete(Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
        // FindByName
    @GetMapping(path = "/byName")
    @Operation(summary = "Find suppliers by name",
                description = "Returns a paginated list of suppliers whose name matchs the provided value.")
    
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the provided name were not found.")
    })
    public ResponseEntity<Page<SupplierResponse>> findByName(
                @RequestParam String name,
                Pageable pageable
    ) {
    
        Page<SupplierResponse> suppliers = supplierService.findByName(name, pageable);
        return ResponseEntity.ok(suppliers);
    }
    
    // FindByContact
    @GetMapping("/byContact")
    @Operation(summary = "Find suppliers by contact",
               description = "Returns a paginated list of suppliers whose contact matches the provided value.")
    
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the provided contact were not found.")
    })
    public ResponseEntity<Page<SupplierResponse>> findByContact(
        @RequestParam String contact,
        Pageable pageable
    ) {
    
        Page<SupplierResponse> suppliers = supplierService.findByContact(contact, pageable);
        return ResponseEntity.ok(suppliers);
    }

    // FindByAddress
    @GetMapping("/byAddress")
    @Operation(summary = "Find suppliers by address",
               description = "Returns a paginated list of suppliers whose address matches the provided value.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the provided address were not found.")
    })
    public ResponseEntity<Page<SupplierResponse>> findByAddress(
        @RequestParam String address,
        Pageable pageable
    ) {
    
        Page<SupplierResponse> suppliers = supplierService.findByAddress(address, pageable);
        return ResponseEntity.ok(suppliers);
    }

    // FindByStatus
    @GetMapping("/byStatus")
    @Operation(summary = "Find suppliers by status",
               description = "Returns a paginated list of suppliers whose status matches the provided value.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the provided status were not found.")
    })
    public ResponseEntity<Page<SupplierResponse>> findByStatus(
        @RequestParam Boolean status,
        Pageable pageable
    ) {
    
        Page<SupplierResponse> suppliers = supplierService.findByStatus(status, pageable);
        return ResponseEntity.ok(suppliers);
    }
    
}
