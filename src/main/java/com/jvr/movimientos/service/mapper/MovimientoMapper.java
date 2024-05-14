package com.jvr.movimientos.service.mapper;

import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.service.dto.MovimientoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoMapper extends EntityMapper<Movimiento, MovimientoDto> {


    @Mapping(source = "numeroCuenta.numeroCuenta", target = "numeroCuenta")
    MovimientoDto toDto(Movimiento entity);

    @Mapping(target = "numeroCuenta.numeroCuenta", source = "numeroCuenta")
    Movimiento toEntity(MovimientoDto dto);
}
