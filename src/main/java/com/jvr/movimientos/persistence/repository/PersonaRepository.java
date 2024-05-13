package com.jvr.movimientos.persistence.repository;

import com.jvr.movimientos.persistence.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}