package com.jvr.movimientos.service;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.persistence.repository.ClienteRepository;
import com.jvr.movimientos.persistence.repository.CuentaRepository;
import com.jvr.movimientos.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class CuentaService extends GenericServiceImp<Cuenta,Integer, CuentaRepository> {
}
