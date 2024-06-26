package com.riwi.RiwiMarket.api.dto.mappers;

import com.riwi.RiwiMarket.api.dto.request.BrandRequest;
import com.riwi.RiwiMarket.api.dto.response.BrandResponse;
import com.riwi.RiwiMarket.domain.entities.Brand;
import com.riwi.RiwiMarket.util.enums.StatusBrand;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandMapper {
    @Mapping(source = "status", target = "status",qualifiedByName = "enumToBoolean")
    Brand requestToBrand(BrandRequest brandRequest);
    @Mapping(source = "status", target = "status",qualifiedByName = "booleanToEnum")
    BrandResponse responseToBrand(Brand brand);

    @Named("booleanToEnum")
    default StatusBrand mapToEnum(boolean status) {
        return status ? StatusBrand.ACTIVE : StatusBrand.INACTIVE;
    }
    @Named("enumToBoolean")
    default boolean mapToBoolean(StatusBrand status) {
        return status == StatusBrand.ACTIVE;
    }

    //METDO PARA SER USADO EN LA ACTUALIZACION DE UNA MARCA este lo puede usar la persona encargada de esa tarea
    @Mapping(target = "id", ignore = true)
    void  updateBrand(BrandRequest request,@MappingTarget Brand brand);
    //pequeño comentario
}
