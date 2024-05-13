package com.jvr.movimientos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {
    @Id
    @Column(name = "numero_cuenta", nullable = false)
    private Integer id;

    @Column(name = "tipo_cuenta", length = 50)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", precision = 10, scale = 2)
    private BigDecimal saldoInicial;

    @Column(name = "estado")
    private Boolean estado;

}