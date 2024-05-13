package com.jvr.movimientos.service.mapper;

import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.service.dto.MovimientoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoMapper extends EntityMapper<Movimiento, MovimientoDto> {


    MovimientoDto toDto(Movimiento entity);


    Movimiento toEntity(MovimientoDto dto);
}
