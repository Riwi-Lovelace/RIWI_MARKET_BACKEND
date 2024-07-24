package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ExpensePatchRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExpenseMapper extends GenericMapper<ExpensePatchRequest, ExpenseCompleteResponse, Expense>{

    @Override
    @Mappings(
            @Mapping(target = "date", ignore = true),
            @Mapping(source = "paymentExpenses", target = "paymentExpenses."),

    )

    List<ExpenseCompleteResponse> listEntities (List<Expense> expenses);
}
