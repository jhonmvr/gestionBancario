package com.jvr.movimientos.persistence.repository;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.persistence.projection.ClienteInfo;
import com.jvr.movimientos.service.dto.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findClienteByIdentificacion_Identificacion(String identificacion);
}