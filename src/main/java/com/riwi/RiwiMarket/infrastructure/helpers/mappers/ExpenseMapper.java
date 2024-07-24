package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.api.dtos.responses.PaymentExpenseResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses={PaymentExpenseMapper.class})
public interface ExpenseMapper extends GenericMapper<ExpenseRequest, ExpenseCompleteResponse, Expense> {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    List<ExpenseCompleteResponse> listEntities(List<Expense> expenses);

    @Override
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "employeeId", target = "employeeId.id"),
            @Mapping(source = "supplierId", target = "supplierId.id"),
            @Mapping(target = "date", ignore = true),
            @Mapping(target = "paymentExpensesId", ignore = true),
    })
    Expense toEntity(ExpenseRequest userRequest);

    @Override
    @Mappings({
            @Mapping(target = "paymentExpenseId", source = "paymentExpensesId"),
            
    })
    
    ExpenseCompleteResponse toResponse(Expense userEntity);


}
