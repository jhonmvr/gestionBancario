package com.jvr.movimientos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable {
    @Id
    @Column(name = "movimiento_id", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    private Instant fecha;

    @Column(name = "tipo_movimiento", length = 50)
    private String tipoMovimiento;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "saldo", precision = 10, scale = 2)
    private BigDecimal saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_cuenta")
    private Cuenta numeroCuenta;

}