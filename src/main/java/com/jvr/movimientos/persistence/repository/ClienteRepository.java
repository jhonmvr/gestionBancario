package com.jvr.movimientos.persistence.repository;

import com.jvr.movimientos.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}