package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.service.dto.MovimientoDto;
import com.jvr.movimientos.service.mapper.MovimientoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController extends GenericController<Movimiento, MovimientoDto, Integer, MovimientoMapper> {

    @Autowired
    private MovimientoMapper movimientoMapper;

}

