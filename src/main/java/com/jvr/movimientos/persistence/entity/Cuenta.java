package com.jvr.movimientos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "numero_cuenta", nullable = false)
    private Integer numeroCuenta;

    @Column(name = "tipo_cuenta", length = 50)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", precision = 10, scale = 2)
    private BigDecimal saldoInicial;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteid")
    private Cliente clienteid;

}