package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.mapper.ClienteMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends GenericController<Cliente, ClienteDto, Integer, ClienteMapper> {

    @Autowired
    private ClienteMapper clienteMapper;

}

