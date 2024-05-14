package com.jvr.movimientos.service.mapper;

import com.jvr.movimientos.persistence.entity.Cliente;
import com.jvr.movimientos.service.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<Cliente, ClienteDto> {


    @Mapping(source = "identificacion.nombre", target = "nombre")
    @Mapping(source = "identificacion.direccion", target = "direccion")
    @Mapping(source = "identificacion.telefono", target = "telefono")
    @Mapping(source = "identificacion.edad", target = "edad")
    @Mapping(source = "identificacion.genero", target = "genero")
    @Mapping(source = "identificacion.identificacion", target = "identificacion")
    @Mapping(source = "contrasena", target = "contrasena")
    @Mapping(source = "estado", target = "estado")
    ClienteDto toDto(Cliente cliente);


    @Mapping(target = "identificacion.nombre", source = "nombre")
    @Mapping(target = "identificacion.direccion", source = "direccion")
    @Mapping(target = "identificacion.telefono", source = "telefono")
    @Mapping(target = "identificacion.edad", source = "edad")
    @Mapping(target = "identificacion.genero", source = "genero")
    @Mapping(target = "identificacion.identificacion", source = "identificacion")
    @Mapping(target = "contrasena", source = "contrasena")
    @Mapping(target = "estado", source = "estado")
    Cliente toEntity(ClienteDto clienteDTO);
}
