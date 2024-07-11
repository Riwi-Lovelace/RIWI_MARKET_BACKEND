package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.domain.entities.Refund;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;



@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RefundMapper extends GenericMapper<RefundRequest, RefundResponse, Refund>{

    RefundResponse entityToResponse(Refund refund);
}
