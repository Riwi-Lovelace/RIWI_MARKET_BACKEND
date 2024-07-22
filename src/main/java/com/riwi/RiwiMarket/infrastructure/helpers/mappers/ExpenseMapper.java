package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExpenseMapper extends GenericMapper<ExpenseRequest, ExpenseCompleteResponse, Expense>{
    List<ExpenseCompleteResponse> listEntities (List<Expense> expenses);

    @Override
    @Mappings({
        @Mapping(target="id",ignore = true),
        @Mapping(source="employeeId",target="employeeId.id"),
        @Mapping(source="employeeId",target="supplierId.id"),
        @Mapping(target="date",ignore = true),
        @Mapping(target="paymentExpenseId",source ="paymentExpenseId.pocketId")
        
    })
     Expense toEntity(ExpenseRequest userRequest) ;
  
    

    @Override
    default ExpenseCompleteResponse toResponse(Expense userEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toResponse'");
    }
}
