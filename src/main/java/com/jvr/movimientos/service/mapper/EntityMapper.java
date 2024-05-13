package com.jvr.movimientos.service.mapper;


public interface EntityMapper<T, DTO> {
    DTO toDto(T entity);
    T toEntity(DTO dto);
}
