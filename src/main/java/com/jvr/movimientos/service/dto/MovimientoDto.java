package com.jvr.movimientos.service.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.jvr.movimientos.persistence.entity.Movimiento}
 */
@Data
public class MovimientoDto implements Serializable {
    Integer id;
    Instant fecha;
    String tipoMovimiento;
    BigDecimal valor;
    BigDecimal saldo;
}