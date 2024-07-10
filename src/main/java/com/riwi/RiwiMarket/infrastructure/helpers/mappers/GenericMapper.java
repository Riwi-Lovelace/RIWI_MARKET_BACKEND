package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

public interface GenericMapper<RequestDTO, ResponseDTO, Entity> {
    
    Entity toEntity(RequestDTO userRequest);

    ResponseDTO toResponse(Entity userEntity);
    
}
