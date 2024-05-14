package com.jvr.movimientos.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.jvr.movimientos.persistence.entity.Cuenta}
 */
@Data
public class CuentaDto implements Serializable {
    Integer numeroCuenta;
    String tipoCuenta;
    BigDecimal saldoInicial;
    Boolean estado;
    String nombre;
    String identificacion;
}