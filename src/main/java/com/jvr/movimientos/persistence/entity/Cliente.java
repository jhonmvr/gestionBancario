package com.jvr.movimientos.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteid", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identificacion")
    private Persona identificacion;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "estado")
    private Boolean estado;

}