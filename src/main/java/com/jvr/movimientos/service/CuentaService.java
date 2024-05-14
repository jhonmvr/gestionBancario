package com.jvr.movimientos.service;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.persistence.entity.Cuenta;
import com.jvr.movimientos.persistence.repository.CuentaRepository;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.dto.CuentaDto;
import com.jvr.movimientos.service.imp.GenericServiceImp;
import com.jvr.movimientos.service.mapper.CuentaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CuentaService extends GenericServiceImp<Cuenta, Integer, CuentaRepository> {
    private final ClienteService clienteService;
    private final CuentaMapper cuentaMapper;
    @Transactional
    public CuentaDto crearNuevaCuenta(CuentaDto dto) {
        Cliente cli =  clienteService.findClienteByIdentificacion_Identificacion(dto.getIdentificacion());
        if(cli == null){
            throw new RuntimeException("no se encontro el cliente con numero de cedula: "+dto.getIdentificacion());
        }
        Cuenta cuenta = cuentaMapper.toEntity(dto);
        cuenta.setClienteid(cli);
        return cuentaMapper.toDto(save(cuenta));
    }
}
