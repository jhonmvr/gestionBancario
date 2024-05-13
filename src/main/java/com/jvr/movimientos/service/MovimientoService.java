package com.jvr.movimientos.service;

import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.persistence.repository.MovimientoRepository;
import com.jvr.movimientos.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService extends GenericServiceImp<Movimiento, Integer, MovimientoRepository> {
}
