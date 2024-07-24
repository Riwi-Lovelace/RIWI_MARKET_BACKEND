package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ExpensePatchRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExpenseMapper extends GenericMapper<ExpensePatchRequest, ExpenseCompleteResponse, Expense>{
    List<ExpenseCompleteResponse> listEntities (List<Expense> expenses);
}
