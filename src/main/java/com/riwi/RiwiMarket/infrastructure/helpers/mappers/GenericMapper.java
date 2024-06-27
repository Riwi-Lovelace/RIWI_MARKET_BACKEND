package com.riwi.RiwiMarket.infrastructure.helpers.mappers;

public interface GenericMapper<RequestDTO, ResponseDTO, Entity> {

    Entity toUserEntity(RequestDTO userRequest);

    ResponseDTO toUserResponse(Entity userEntity);

}
