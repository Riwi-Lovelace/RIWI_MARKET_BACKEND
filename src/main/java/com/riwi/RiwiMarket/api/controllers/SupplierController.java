package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.domain.entities.Supplier;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/supplier")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class SupplierController implements GenericController<SupplierRequest, SupplierResponse, Long> {

    @Autowired
    private final ISupplierService supplierService;

    @Override
    @Operation(summary = "Create supplier", description = "Add a new supplier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Create the new supplier."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the incorrect request")
    })
    @PostMapping
    public ResponseEntity<SupplierResponse> create(
            @Validated @RequestBody SupplierRequest request) {
        return ResponseEntity.ok(this.supplierService.create(request));
    }

    // findById
    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Find supplier by ID", description = "Returns the supplier with the specified ID.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the supplier."),
            @ApiResponse(responseCode = "404", description = "Supplier not found with the specified ID.")
    })
    public ResponseEntity<SupplierResponse> read(@PathVariable Long id) {

        SupplierResponse supplier = supplierService.read(id);

        if (supplier != null) {
            return ResponseEntity.ok(supplier);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method pach for active o disable this service
    @PatchMapping("/{id}/status")
    @Operation(summary = "Find suppliers by name", description = "Returns a paginated list of suppliers whose name matchs the provided value.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the provided name were not found.")
    })
    public ResponseEntity<Supplier> suplierUpdateStatus(@PathVariable Long id) {
        supplierService.disableSuplier(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Find suppliers by name", description = "Returns a paginated list of suppliers whose name matchs the provided value.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Suppliers with the provided name were not found.")
    })
    @Override
    public ResponseEntity<SupplierResponse> update(@Validated @RequestBody SupplierRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.supplierService.update(id, request));
    }

    // findAll
    @GetMapping
    @Operation(summary = "List all suppliers", description = "Returns a paginated list of all suppliers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<Page<SupplierResponse>> findAll(            
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "") String name,
        @RequestParam(defaultValue = "") String contact,
        @RequestParam(defaultValue = "") String address
    ) {
        Page<SupplierResponse> suppliers = supplierService.findByAddressContainingOrContactContainingOrNameContaining(page-1, size, name, contact, address);
        return ResponseEntity.ok(suppliers);
    }




    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
