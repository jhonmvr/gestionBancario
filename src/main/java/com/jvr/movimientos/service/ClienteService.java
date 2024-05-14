package com.jvr.movimientos.service;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.persistence.repository.ClienteRepository;
import com.jvr.movimientos.persistence.repository.PersonaRepository;
import com.jvr.movimientos.service.dto.ClienteDto;
import com.jvr.movimientos.service.imp.GenericServiceImp;
import com.jvr.movimientos.service.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService extends GenericServiceImp<Cliente, Integer, ClienteRepository> {
    private final ClienteMapper clienteMapper;
    private final PersonaService personaService;
    private final ClienteRepository clienteRepository;
    @Transactional
    public ClienteDto createNuevoCliente(ClienteDto dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        personaService.save(cliente.getIdentificacion());
        return clienteMapper.toDto(save(cliente));
    }

    public Cliente findClienteByIdentificacion_Identificacion(String identificacion) {
        return clienteRepository.findClienteByIdentificacion_Identificacion(identificacion).orElse(null);
    }
}
