package com.riwi.RiwiMarket.infraestructure.abstrac_service;

import com.riwi.RiwiMarket.api.dto.request.BrandRequest;
import com.riwi.RiwiMarket.api.dto.response.BrandResponse;

public interface IBrandService extends CrudService<BrandRequest, BrandResponse,Long> {
}
