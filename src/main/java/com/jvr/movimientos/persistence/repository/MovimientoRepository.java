package com.jvr.movimientos.persistence.repository;

import com.jvr.movimientos.persistence.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}