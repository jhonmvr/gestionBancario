package com.jvr.movimientos.persistence.repository;

import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.service.dto.EstadoDeCuentaReporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    List<Movimiento> findMovimientoByFechaIsBetweenAndNumeroCuenta_Clienteid_Identificacion_Identificacion(Instant fecha, Instant fecha2, String numeroCuenta_clienteid_identificacion_identificacion);
}