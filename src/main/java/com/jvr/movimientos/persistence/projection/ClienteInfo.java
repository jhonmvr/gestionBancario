package com.jvr.movimientos.persistence.projection;

/**
 * Projection for {@link com.jvr.movimientos.persistence.entity.Cliente}
 */
public interface ClienteInfo {
    Integer getId();

    String getContrasena();

    Boolean isEstado();
}