package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ReturnRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ReturnResponse;
import com.riwi.RiwiMarket.domain.entities.Return;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReturnMapper extends GenericMapper<ReturnRequest, ReturnResponse, Return>{

    List<ReturnResponse> ReturnListToResponseList(List<Return> returns);
}
