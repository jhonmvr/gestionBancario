package com.jvr.movimientos.service.mapper;

import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.service.dto.CuentaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CuentaMapper extends EntityMapper<Cuenta, CuentaDto> {


    @Mapping(source = "clienteid.identificacion.nombre", target = "nombre")
    @Mapping(source = "clienteid.identificacion.identificacion", target = "identificacion")
    CuentaDto toDto(Cuenta entity);

    @Mapping(target = "clienteid.identificacion.nombre", source = "nombre")
    @Mapping(target = "clienteid.identificacion.identificacion", source = "identificacion")
    Cuenta toEntity(CuentaDto dto);
}
