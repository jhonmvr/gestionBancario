package com.jvr.movimientos.service.mapper;

import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.service.dto.CuentaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaMapper extends EntityMapper<Cuenta, CuentaDto> {


    CuentaDto toDto(Cuenta entity);


    Cuenta toEntity(CuentaDto dto);
}
