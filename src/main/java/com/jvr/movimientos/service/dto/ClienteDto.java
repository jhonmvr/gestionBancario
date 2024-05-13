package com.jvr.movimientos.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.jvr.movimientos.persistence.entity.Cliente}
 */

@Data
public class ClienteDto implements Serializable {
    private Integer id;
    private String contrasena;
    private Boolean estado;

}