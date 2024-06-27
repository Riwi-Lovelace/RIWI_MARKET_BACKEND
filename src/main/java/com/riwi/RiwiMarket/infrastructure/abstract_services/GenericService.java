package com.riwi.RiwiMarket.infrastructure.abstract_services;

public interface GenericService<RequestDTO, ResponseDTO, ID> {

    ResponseDTO create(RequestDTO request);

    ResponseDTO read(ID id);

    ResponseDTO update(ID id, RequestDTO request);

    void disableSuplier(ID id);

}