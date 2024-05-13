package com.jvr.movimientos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name = "identificacion", nullable = false, length = 10)
    private String identificacion;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "genero", length = 10)
    private String genero;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono", length = 50)
    private String telefono;

}