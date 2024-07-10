package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.domain.entities.Refund;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RefundMapper extends GenericMapper<RefundRequest, RefundResponse, Refund>{

    @Override
    public Refund toEntity(RefundRequest request);

    @Override
    @InheritInverseConfiguration
    public RefundResponse toResponse(Refund refund);

    List<RefundResponse> RefundListToResponseList(List<Refund> refunds);
}
