package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseBasicResponse;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseToEmployeeResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExpenseMapper extends GenericMapper<ExpenseRequest, ExpenseCompleteResponse, Expense>{
    List<ExpenseCompleteResponse> listEntities (List<Expense> expenses);

    ExpenseBasicResponse entityToBasicResponse(Expense expense);



}
