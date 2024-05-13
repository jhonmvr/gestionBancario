package com.jvr.movimientos.persistence.repository;

import com.jvr.movimientos.persistence.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}