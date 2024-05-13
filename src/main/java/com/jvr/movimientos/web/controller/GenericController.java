package com.jvr.movimientos.web.controller;

import com.jvr.movimientos.service.GenericService;
import com.jvr.movimientos.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


public abstract class GenericController<T, DTO, ID, M extends EntityMapper<T, DTO>> {

    @Autowired
    private GenericService<T, ID> service;

    @Autowired
    private M mapper;  // El mapper de MapStruct

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody T entity) {

        T savedEntity = service.save(entity);
        DTO savedDto = mapper.toDto(savedEntity);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(mapper.toDto(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        List<T> entities = service.findAll();
        List<DTO> dtos = entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) {
        T entity = mapper.toEntity(dto);
        try {
            T updatedEntity = service.update(id, entity);
            DTO updatedDto = mapper.toDto(updatedEntity);
            return ResponseEntity.ok(updatedDto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
