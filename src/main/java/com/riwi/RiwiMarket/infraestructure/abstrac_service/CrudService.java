package com.riwi.RiwiMarket.infraestructure.abstrac_service;

public interface CrudService <RQ,RS,ID>{
    public RS create(RQ request);
}
