package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.ConfiguracionReporte;
import com.quarksoft.reportes.service.ConfiguracionReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/configuracion")
@RequiredArgsConstructor
public class ConfiguracionReporteController {
    private final ConfiguracionReporteService service;

    @GetMapping
    public List<ConfiguracionReporte> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracionReporte> getById(@PathVariable Integer id) {
        ConfiguracionReporte entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ConfiguracionReporte> create(@RequestBody ConfiguracionReporte config) {
        return ResponseEntity.ok(service.create(config));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracionReporte> update(@PathVariable Integer id, @RequestBody ConfiguracionReporte config) {
        return ResponseEntity.ok(service.update(id, config));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
