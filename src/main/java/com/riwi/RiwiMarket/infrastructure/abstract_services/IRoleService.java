package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.RoleRequest;
import com.riwi.RiwiMarket.api.dtos.requests.RoleRequestIsActive;
import com.riwi.RiwiMarket.api.dtos.responses.RoleResponse;

public interface IRoleService extends GenericService<RoleRequest, RoleResponse, Long> {
    public RoleResponse updateIsActive(Long id, RoleRequestIsActive requestIsActive);
}
