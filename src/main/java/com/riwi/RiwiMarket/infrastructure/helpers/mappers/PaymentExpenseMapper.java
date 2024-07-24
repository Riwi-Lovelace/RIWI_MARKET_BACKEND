package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.RiwiMarket.api.dtos.requests.PaymentExpenseRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PaymentExpenseResponse;
import com.riwi.RiwiMarket.domain.entities.PaymentExpense;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses={PocketMapper.class})

public interface PaymentExpenseMapper extends GenericMapper<PaymentExpenseRequest, PaymentExpenseResponse, PaymentExpense> {

    @Override
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "expenseId.id", ignore=true),
        @Mapping(target = "pocketId.id", source = "pocketId")

    })
    
     PaymentExpense toEntity(PaymentExpenseRequest userRequest);

    @Override
    @Mapping(target = "pocket", source = "pocketId")
     PaymentExpenseResponse toResponse(PaymentExpense userEntity);

    List<PaymentExpenseResponse> listEntities(List<PaymentExpense> paymentExpenses);

}
