package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.riwi.RiwiMarket.api.dtos.requests.ItemRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;
import com.riwi.RiwiMarket.domain.entities.Item;
import org.mapstruct.MappingConstants;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper extends GenericMapper<ItemRequest,ItemResponse,Item>{

    @Override
    default Item toEntity(ItemRequest userRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    @InheritInverseConfiguration
    public ItemResponse toResponse(Item userEntity) ;
    
}
