package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.service.MovimientoService;
import com.jvr.movimientos.service.dto.CuentaDto;
import com.jvr.movimientos.service.dto.EstadoDeCuentaReporte;
import com.jvr.movimientos.service.dto.MovimientoDto;
import com.jvr.movimientos.service.mapper.MovimientoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController extends GenericController<Movimiento, MovimientoDto, Integer, MovimientoMapper> {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/registrarMovimiento")
    public ResponseEntity<MovimientoDto> registrarMovimiento(@RequestBody MovimientoDto dto) {
        return ResponseEntity.ok(movimientoService.registrarMovimiento(dto));
    }

    @GetMapping("/reporte")
    public ResponseEntity<List<EstadoDeCuentaReporte>> obtenerReporteEstadoDeCuenta(
            @RequestParam String identificacion,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant fechaFin) {

        List<EstadoDeCuentaReporte> reporte = movimientoService.generarEstadoDeCuenta( fechaInicio, fechaFin,identificacion);
        return ResponseEntity.ok(reporte);
    }

}

