package com.riwi.RiwiMarket.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.RoleRequest;
import com.riwi.RiwiMarket.api.dtos.requests.RoleRequestIsActive;
import com.riwi.RiwiMarket.api.dtos.responses.RoleResponse;
import com.riwi.RiwiMarket.domain.entities.Role;
import com.riwi.RiwiMarket.domain.repositories.RoleRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRoleService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.RoleMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {


    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final RoleMapper roleMapper;
    @Autowired
    private final SupportService<Role> supportService;

    @Override
    public RoleResponse create(RoleRequest request) {
        return this.roleMapper.toResponse(this.roleRepository.save(this.roleMapper.toEntity(request)));
    }

    @Override
    public RoleResponse read(Long id) {
        return this.roleMapper.toResponse(this.supportService.findById(roleRepository, id, "Role"));
    }

    @Override
    public RoleResponse update(Long id, RoleRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        this.roleRepository.delete(this.supportService.findById(roleRepository, id, "Role"));
    }

    @Override
    public RoleResponse updateIsActive(Long id, RoleRequestIsActive requestIsActive) {
        Role roleUpdate = this.supportService.findById(roleRepository, id, "Role");
        roleUpdate.setName(requestIsActive.getName());
        roleUpdate.setIsActive(requestIsActive.getIsActive());
        roleUpdate.setId(id);
        return this.roleMapper.toResponse(this.roleRepository.save(roleUpdate));
    }
    
}
