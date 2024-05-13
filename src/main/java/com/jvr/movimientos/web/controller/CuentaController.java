package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController extends GenericController<Cuenta, ClienteDto, Integer, ClienteMapper> {

    @Autowired
    private ClienteMapper clienteMapper;

}

