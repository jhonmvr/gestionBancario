package com.jvr.movimientos.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class EstadoDeCuentaReporte implements Serializable {
    private String fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private BigDecimal saldoInicial;
    private Boolean estado;
    private BigDecimal movimiento;
    private BigDecimal saldoDisponible;
}
