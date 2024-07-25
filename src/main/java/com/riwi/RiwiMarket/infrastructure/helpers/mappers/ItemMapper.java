package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import com.riwi.RiwiMarket.api.dtos.requests.ItemRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;
import com.riwi.RiwiMarket.domain.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper extends GenericMapper<ItemRequest, ItemResponse, Item> {
    List<ItemResponse> toListResponse(List<Item> list);
}

