package com.riwi.RiwiMarket.api.abstract_controller;

import org.springframework.http.ResponseEntity;

import com.riwi.RiwiMarket.api.dtos.requests.RoleRequest;
import com.riwi.RiwiMarket.api.dtos.requests.RoleRequestIsActive;
import com.riwi.RiwiMarket.api.dtos.responses.RoleResponse;

public interface IRoleController extends GenericController<RoleRequest, RoleResponse, Long> {
    public ResponseEntity<RoleResponse> updateIsActive(RoleRequestIsActive requestIsActive, Long id);
}
