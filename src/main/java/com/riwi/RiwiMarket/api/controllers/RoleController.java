package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.riwi.RiwiMarket.api.abstract_controller.IRoleController;
import com.riwi.RiwiMarket.api.dtos.requests.RoleRequest;
import com.riwi.RiwiMarket.api.dtos.requests.RoleRequestIsActive;
import com.riwi.RiwiMarket.api.dtos.responses.RoleResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/role")
@AllArgsConstructor
@Tag(name = "Roles")
public class RoleController implements IRoleController {
    
    @Autowired
    private final IRoleService roleService;

    @ApiResponse(
        responseCode = "200",
        description = "Succesful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "Data incorrect or incomplete",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )}
    )
    @Operation(summary = "Create new role", description = "Create new roles for implementation in security")
    @PostMapping
    @Override
    public ResponseEntity<RoleResponse> create(@Validated @RequestBody RoleRequest request) {
        return ResponseEntity.ok(this.roleService.create(request));
    }

    @ApiResponse(
        responseCode = "200",
        description = "Succesful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "Data incorrect or incomplete",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )}
    )
    @Operation(summary = "Find role", description = "Find roles by id")
    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<RoleResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.roleService.read(id));
    }

    @Override
    public ResponseEntity<RoleResponse> update(RoleRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @ApiResponse(
        responseCode = "200",
        description = "Succesful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "Data incorrect or incomplete",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )}
    )
    @Operation(summary = "Delete role", description = "Delete roles by id")
    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.roleService.delete(id);
       return ResponseEntity.noContent().build();
    }

    @ApiResponse(
        responseCode = "200",
        description = "Succesful operation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
    )
    @ApiResponse(
        responseCode = "400",
        description = "Data incorrect or incomplete",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )}
    )
    @Operation(summary = "Update role", description = "Update roles Active or Inactive and name")
    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<RoleResponse> updateIsActive(@Validated @RequestBody RoleRequestIsActive requestIsActive,@PathVariable Long id) {
        return ResponseEntity.ok(this.roleService.updateIsActive(id, requestIsActive));
    }
    
}
