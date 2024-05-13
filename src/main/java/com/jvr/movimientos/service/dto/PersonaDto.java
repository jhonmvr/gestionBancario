package com.jvr.movimientos.service.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.jvr.movimientos.persistence.entity.Persona}
 */
@Data
public class PersonaDto implements Serializable {
    String identificacion;
    String nombre;
    String genero;
    Integer edad;
    String direccion;
    String telefono;
}