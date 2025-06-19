package com.quarksoft.reportes.controller;

import com.quarksoft.reportes.entity.MetricaRendimiento;
import com.quarksoft.reportes.service.MetricaRendimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/metricas")
@RequiredArgsConstructor
public class MetricaRendimientoController {
    private final MetricaRendimientoService service;

    @GetMapping
    public List<MetricaRendimiento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetricaRendimiento> getById(@PathVariable Integer id) {
        MetricaRendimiento entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MetricaRendimiento> create(@RequestBody MetricaRendimiento metrica) {
        return ResponseEntity.ok(service.create(metrica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetricaRendimiento> update(@PathVariable Integer id, @RequestBody MetricaRendimiento metrica) {
        return ResponseEntity.ok(service.update(id, metrica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
