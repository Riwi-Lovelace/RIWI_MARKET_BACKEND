package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.domain.entities.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StockMapper extends GenericMapper<StockRequest, StockResponse, Stock>{
    List<StockResponse> listEntitiesToStockResp(List<Stock> stocks);

    Stock toEntityUpdateQuantity(StockUpdateRequest userRequest);

    Stock toEntityUpdateWeight(StockWeightUpdateRequest userRequest);
}
