package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.service.CuentaService;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.dto.CuentaDto;
import com.jvr.movimientos.service.mapper.CuentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController extends GenericController<Cuenta, CuentaDto, Integer, CuentaMapper> {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/crearNuevaCuenta")
    public ResponseEntity<CuentaDto> crearNuevaCuenta(@RequestBody CuentaDto dto) {
        return ResponseEntity.ok(cuentaService.crearNuevaCuenta(dto));
    }

}

