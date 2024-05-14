package com.jvr.movimientos.service;

import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.persistence.entity.Movimiento;
import com.jvr.movimientos.persistence.enums.TipoMovimientoEnum;
import com.jvr.movimientos.persistence.repository.MovimientoRepository;
import com.jvr.movimientos.service.dto.EstadoDeCuentaReporte;
import com.jvr.movimientos.service.dto.MovimientoDto;
import com.jvr.movimientos.service.imp.GenericServiceImp;
import com.jvr.movimientos.service.mapper.MovimientoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovimientoService extends GenericServiceImp<Movimiento, Integer, MovimientoRepository> {
    private final MovimientoMapper movimientoMapper;
    private final CuentaService cuentaService;
    private final MovimientoRepository movimientoRepository;
    @Transactional
    public MovimientoDto registrarMovimiento(MovimientoDto dto) {
        Movimiento movimiento = movimientoMapper.toEntity(dto);
        Cuenta cuenta = cuentaService.findById(dto.getNumeroCuenta()).orElse(null);
        if(cuenta == null){
            throw new RuntimeException("no se encontro numero de cuenta: "+dto.getNumeroCuenta());
        }
        if (!(movimiento.getValor().compareTo(BigDecimal.ZERO) > 0 && movimiento.getTipoMovimiento().equals(TipoMovimientoEnum.DEPOSITO)) &&
                !(movimiento.getValor().compareTo(BigDecimal.ZERO) < 0 && movimiento.getTipoMovimiento().equals(TipoMovimientoEnum.RETIRO))) {
            throw new RuntimeException("NO SE PUEDE REGISTRAR EL DEPOSITO POR QUE NO SE PUEDE ASIGNAR UN VALOR: " + dto.getValor() + " A UN TIPO DE MOVIMIENTO: " + dto.getTipoMovimiento());
        }
        if(movimiento.getTipoMovimiento().equals(TipoMovimientoEnum.RETIRO) && cuenta.getSaldoInicial().compareTo(BigDecimal.ZERO) == 0){
            throw new RuntimeException("NO HAY SALDO SUFICIENTE EN LA CUENTA");
        }
        movimiento.setFecha(Instant.now());
        cuenta.setSaldoInicial(cuenta.getSaldoInicial().add(movimiento.getValor()));
        cuentaService.save(cuenta);

        return movimientoMapper.toDto(save(movimiento));



    }

    public List<EstadoDeCuentaReporte> generarEstadoDeCuenta( Instant fechaInicio, Instant fechaFin, String identificacion) {
        List<Movimiento> movimientos = movimientoRepository.findMovimientoByFechaIsBetweenAndNumeroCuenta_Clienteid_Identificacion_Identificacion(fechaInicio,fechaFin,identificacion);

        return movimientos.stream().map(this::convertirAMovimientoDTO).collect(Collectors.toList());

    }

    private EstadoDeCuentaReporte convertirAMovimientoDTO(Movimiento movimiento) {
        EstadoDeCuentaReporte dto = new EstadoDeCuentaReporte();
        dto.setFecha(movimiento.getFecha().toString());
        dto.setCliente(movimiento.getNumeroCuenta().getClienteid().getIdentificacion().getNombre());
        dto.setNumeroCuenta(movimiento.getNumeroCuenta().getNumeroCuenta().toString());
        dto.setTipo(movimiento.getNumeroCuenta().getTipoCuenta());
        dto.setSaldoInicial(movimiento.getNumeroCuenta().getSaldoInicial());
        dto.setEstado(movimiento.getNumeroCuenta().getEstado());
        dto.setMovimiento(movimiento.getValor());
        dto.setSaldoDisponible(movimiento.getNumeroCuenta().getSaldoInicial());
        return dto;
    }
}
