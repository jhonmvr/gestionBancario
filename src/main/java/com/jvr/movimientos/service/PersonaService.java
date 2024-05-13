package com.jvr.movimientos.service;

import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.persistence.entity.Persona;
import com.jvr.movimientos.persistence.repository.CuentaRepository;
import com.jvr.movimientos.persistence.repository.PersonaRepository;
import com.jvr.movimientos.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class PersonaService extends GenericServiceImp<Persona,Integer, PersonaRepository> {
}
