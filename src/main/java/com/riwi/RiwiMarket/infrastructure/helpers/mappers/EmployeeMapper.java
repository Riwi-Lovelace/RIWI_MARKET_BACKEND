package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.EmployeeRequest;
import com.riwi.RiwiMarket.api.dtos.responses.EmployeeResponse;
import com.riwi.RiwiMarket.domain.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper extends GenericMapper<EmployeeRequest, EmployeeResponse, Employee> {
    List<EmployeeResponse> listEntitiesToEmployeeResp(List<Employee> employees);
}
