package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.service.ClienteService;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends GenericController<Cliente, ClienteDto, Integer, ClienteMapper> {


    @Autowired
    private ClienteService clienteService;


    @PostMapping("/createNuevoCliente")
    public ResponseEntity<ClienteDto> createNuevoCliente(@RequestBody ClienteDto dto) {
        return ResponseEntity.ok(clienteService.createNuevoCliente(dto));
    }

}

