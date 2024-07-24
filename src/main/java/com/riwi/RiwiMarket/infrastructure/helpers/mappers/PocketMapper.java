package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ExpenseCompleteResponse;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import com.riwi.RiwiMarket.domain.entities.Expense;
import com.riwi.RiwiMarket.domain.entities.Pocket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PocketMapper extends GenericMapper<PocketRequest, PocketResponse, Pocket>{

    PocketMapper INSTANCE = Mappers.getMapper(PocketMapper.class);
    
   
    List<PocketResponse> listEntitiesToPocketResp(List<Pocket> pockets);
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "paymentExpenses", ignore = true),
    })
    Pocket toEntity(PocketRequest userRequest);
   PocketResponse toResponse(Pocket userEntity);
}
