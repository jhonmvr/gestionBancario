package com.jvr.movimientos.service.mapper;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.service.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<Cliente, ClienteDto> {

    ClienteDto toDto(Cliente cliente);

    Cliente toEntity(ClienteDto clienteDTO);
}
